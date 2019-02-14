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

package com.liferay.social.networking.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.social.networking.model.WallEntry;
import com.liferay.social.networking.service.WallEntryLocalServiceUtil;

/**
 * The extended model base implementation for the WallEntry service. Represents a row in the &quot;SN_WallEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WallEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WallEntryImpl
 * @see WallEntry
 * @generated
 */
@ProviderType
public abstract class WallEntryBaseImpl extends WallEntryModelImpl
	implements WallEntry {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wall entry model instance should use the <code>WallEntry</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			WallEntryLocalServiceUtil.addWallEntry(this);
		}
		else {
			WallEntryLocalServiceUtil.updateWallEntry(this);
		}
	}
}