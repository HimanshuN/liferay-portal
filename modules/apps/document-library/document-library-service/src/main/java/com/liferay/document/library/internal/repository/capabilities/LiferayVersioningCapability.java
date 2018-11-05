/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.document.library.internal.repository.capabilities;

import com.liferay.document.library.configuration.DLConfiguration;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.versioning.VersionPurger;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerList;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerListFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.LocalRepository;
import com.liferay.portal.kernel.repository.Repository;
import com.liferay.portal.kernel.repository.capabilities.Capability;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackUtil;
import com.liferay.portal.repository.util.LocalRepositoryWrapper;
import com.liferay.portal.repository.util.RepositoryWrapper;
import com.liferay.portal.repository.util.RepositoryWrapperAware;

import java.io.File;
import java.io.InputStream;

import java.util.concurrent.Callable;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = "repository.class.name=com.liferay.portal.repository.liferayrepository.LiferayRepository",
	service = Capability.class
)
public class LiferayVersioningCapability
	implements Capability, RepositoryWrapperAware {

	@Override
	public LocalRepository wrapLocalRepository(
		LocalRepository localRepository) {

		return new LocalRepositoryWrapper(localRepository) {

			@Override
			public FileEntry updateFileEntry(
					long userId, long fileEntryId, String sourceFileName,
					String mimeType, String title, String description,
					String changeLog,
					DLVersionNumberIncrease dlVersionNumberIncrease, File file,
					ServiceContext serviceContext)
				throws PortalException {

				return _purgeVersions(
					super.updateFileEntry(
						userId, fileEntryId, sourceFileName, mimeType, title,
						description, changeLog, dlVersionNumberIncrease, file,
						serviceContext));
			}

			@Override
			public FileEntry updateFileEntry(
					long userId, long fileEntryId, String sourceFileName,
					String mimeType, String title, String description,
					String changeLog,
					DLVersionNumberIncrease dlVersionNumberIncrease,
					InputStream is, long size, ServiceContext serviceContext)
				throws PortalException {

				return _purgeVersions(
					super.updateFileEntry(
						userId, fileEntryId, sourceFileName, mimeType, title,
						description, changeLog, dlVersionNumberIncrease, is,
						size, serviceContext));
			}

		};
	}

	@Override
	public Repository wrapRepository(Repository repository) {
		return new RepositoryWrapper(repository) {

			@Override
			public FileEntry updateFileEntry(
					long userId, long fileEntryId, String sourceFileName,
					String mimeType, String title, String description,
					String changeLog,
					DLVersionNumberIncrease dlVersionNumberIncrease, File file,
					ServiceContext serviceContext)
				throws PortalException {

				return _purgeVersions(
					super.updateFileEntry(
						userId, fileEntryId, sourceFileName, mimeType, title,
						description, changeLog, dlVersionNumberIncrease, file,
						serviceContext));
			}

			@Override
			public FileEntry updateFileEntry(
					long userId, long fileEntryId, String sourceFileName,
					String mimeType, String title, String description,
					String changeLog,
					DLVersionNumberIncrease dlVersionNumberIncrease,
					InputStream is, long size, ServiceContext serviceContext)
				throws PortalException {

				return _purgeVersions(
					super.updateFileEntry(
						userId, fileEntryId, sourceFileName, mimeType, title,
						description, changeLog, dlVersionNumberIncrease, is,
						size, serviceContext));
			}

		};
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_versionPurgedListeners = ServiceTrackerListFactory.open(
			bundleContext, VersionPurger.VersionPurgedListener.class);
	}

	@Deactivate
	protected void deactivate() {
		_versionPurgedListeners.close();
	}

	private FileEntry _purgeVersions(FileEntry fileEntry) {
		if (_versionPurger == null) {
			return fileEntry;
		}

		TransactionCommitCallbackUtil.registerCallback(
			(Callable<Void>)() -> {
				for (FileVersion fileVersion :
						_versionPurger.getFileVersionsToPurge(fileEntry)) {

					for (VersionPurger.VersionPurgedListener
							versionPurgedListener : _versionPurgedListeners) {

						versionPurgedListener.versionPurged(fileVersion);
					}

					_dlAppService.deleteFileVersion(
						fileEntry.getFileEntryId(), fileVersion.getVersion());
				}

				return null;
			});

		return fileEntry;
	}

	@Reference
	private DLAppService _dlAppService;

	@Reference
	private DLConfiguration _dlConfiguration;

	private ServiceTrackerList
		<VersionPurger.VersionPurgedListener,
		 VersionPurger.VersionPurgedListener> _versionPurgedListeners;

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile VersionPurger _versionPurger;

}