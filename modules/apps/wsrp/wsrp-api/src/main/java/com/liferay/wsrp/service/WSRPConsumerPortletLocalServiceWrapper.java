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

package com.liferay.wsrp.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WSRPConsumerPortletLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WSRPConsumerPortletLocalService
 * @generated
 */
@ProviderType
public class WSRPConsumerPortletLocalServiceWrapper
	implements WSRPConsumerPortletLocalService,
		ServiceWrapper<WSRPConsumerPortletLocalService> {
	public WSRPConsumerPortletLocalServiceWrapper(
		WSRPConsumerPortletLocalService wsrpConsumerPortletLocalService) {
		_wsrpConsumerPortletLocalService = wsrpConsumerPortletLocalService;
	}

	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet addWSRPConsumerPortlet(
		long wsrpConsumerId, String name, String portletHandle,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.addWSRPConsumerPortlet(wsrpConsumerId,
			name, portletHandle, serviceContext);
	}

	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet addWSRPConsumerPortlet(
		String wsrpConsumerUuid, String name, String portletHandle,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.addWSRPConsumerPortlet(wsrpConsumerUuid,
			name, portletHandle, serviceContext);
	}

	/**
	* Adds the wsrp consumer portlet to the database. Also notifies the appropriate model listeners.
	*
	* @param wsrpConsumerPortlet the wsrp consumer portlet
	* @return the wsrp consumer portlet that was added
	*/
	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet addWSRPConsumerPortlet(
		com.liferay.wsrp.model.WSRPConsumerPortlet wsrpConsumerPortlet) {
		return _wsrpConsumerPortletLocalService.addWSRPConsumerPortlet(wsrpConsumerPortlet);
	}

	/**
	* Creates a new wsrp consumer portlet with the primary key. Does not add the wsrp consumer portlet to the database.
	*
	* @param wsrpConsumerPortletId the primary key for the new wsrp consumer portlet
	* @return the new wsrp consumer portlet
	*/
	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet createWSRPConsumerPortlet(
		long wsrpConsumerPortletId) {
		return _wsrpConsumerPortletLocalService.createWSRPConsumerPortlet(wsrpConsumerPortletId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the wsrp consumer portlet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wsrpConsumerPortletId the primary key of the wsrp consumer portlet
	* @return the wsrp consumer portlet that was removed
	* @throws PortalException if a wsrp consumer portlet with the primary key could not be found
	*/
	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet deleteWSRPConsumerPortlet(
		long wsrpConsumerPortletId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.deleteWSRPConsumerPortlet(wsrpConsumerPortletId);
	}

	@Override
	public void deleteWSRPConsumerPortlet(String wsrpConsumerPortletUuid)
		throws com.liferay.portal.kernel.exception.PortalException {
		_wsrpConsumerPortletLocalService.deleteWSRPConsumerPortlet(wsrpConsumerPortletUuid);
	}

	/**
	* Deletes the wsrp consumer portlet from the database. Also notifies the appropriate model listeners.
	*
	* @param wsrpConsumerPortlet the wsrp consumer portlet
	* @return the wsrp consumer portlet that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet deleteWSRPConsumerPortlet(
		com.liferay.wsrp.model.WSRPConsumerPortlet wsrpConsumerPortlet)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.deleteWSRPConsumerPortlet(wsrpConsumerPortlet);
	}

	@Override
	public void deleteWSRPConsumerPortlets(long wsrpConsumerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_wsrpConsumerPortletLocalService.deleteWSRPConsumerPortlets(wsrpConsumerId);
	}

	@Override
	public void destroyWSRPConsumerPortlet(long wsrpConsumerPortletId,
		String wsrpConsumerPortletUuid, String url) {
		_wsrpConsumerPortletLocalService.destroyWSRPConsumerPortlet(wsrpConsumerPortletId,
			wsrpConsumerPortletUuid, url);
	}

	@Override
	public void destroyWSRPConsumerPortlets()
		throws com.liferay.portal.kernel.exception.PortalException {
		_wsrpConsumerPortletLocalService.destroyWSRPConsumerPortlets();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wsrpConsumerPortletLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _wsrpConsumerPortletLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.wsrp.model.impl.WSRPConsumerPortletModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _wsrpConsumerPortletLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.wsrp.model.impl.WSRPConsumerPortletModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _wsrpConsumerPortletLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _wsrpConsumerPortletLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _wsrpConsumerPortletLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet fetchWSRPConsumerPortlet(
		long wsrpConsumerPortletId) {
		return _wsrpConsumerPortletLocalService.fetchWSRPConsumerPortlet(wsrpConsumerPortletId);
	}

	/**
	* Returns the wsrp consumer portlet with the matching UUID and company.
	*
	* @param uuid the wsrp consumer portlet's UUID
	* @param companyId the primary key of the company
	* @return the matching wsrp consumer portlet, or <code>null</code> if a matching wsrp consumer portlet could not be found
	*/
	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet fetchWSRPConsumerPortletByUuidAndCompanyId(
		String uuid, long companyId) {
		return _wsrpConsumerPortletLocalService.fetchWSRPConsumerPortletByUuidAndCompanyId(uuid,
			companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _wsrpConsumerPortletLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _wsrpConsumerPortletLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _wsrpConsumerPortletLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _wsrpConsumerPortletLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the wsrp consumer portlet with the primary key.
	*
	* @param wsrpConsumerPortletId the primary key of the wsrp consumer portlet
	* @return the wsrp consumer portlet
	* @throws PortalException if a wsrp consumer portlet with the primary key could not be found
	*/
	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet getWSRPConsumerPortlet(
		long wsrpConsumerPortletId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.getWSRPConsumerPortlet(wsrpConsumerPortletId);
	}

	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet getWSRPConsumerPortlet(
		long wsrpConsumerId, String portletHandle)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.getWSRPConsumerPortlet(wsrpConsumerId,
			portletHandle);
	}

	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet getWSRPConsumerPortlet(
		String wsrpConsumerPortletUuid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.getWSRPConsumerPortlet(wsrpConsumerPortletUuid);
	}

	/**
	* Returns the wsrp consumer portlet with the matching UUID and company.
	*
	* @param uuid the wsrp consumer portlet's UUID
	* @param companyId the primary key of the company
	* @return the matching wsrp consumer portlet
	* @throws PortalException if a matching wsrp consumer portlet could not be found
	*/
	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet getWSRPConsumerPortletByUuidAndCompanyId(
		String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.getWSRPConsumerPortletByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of all the wsrp consumer portlets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.wsrp.model.impl.WSRPConsumerPortletModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsrp consumer portlets
	* @param end the upper bound of the range of wsrp consumer portlets (not inclusive)
	* @return the range of wsrp consumer portlets
	*/
	@Override
	public java.util.List<com.liferay.wsrp.model.WSRPConsumerPortlet> getWSRPConsumerPortlets(
		int start, int end) {
		return _wsrpConsumerPortletLocalService.getWSRPConsumerPortlets(start,
			end);
	}

	@Override
	public java.util.List<com.liferay.wsrp.model.WSRPConsumerPortlet> getWSRPConsumerPortlets(
		long wsrpConsumerId, int start, int end) {
		return _wsrpConsumerPortletLocalService.getWSRPConsumerPortlets(wsrpConsumerId,
			start, end);
	}

	/**
	* Returns the number of wsrp consumer portlets.
	*
	* @return the number of wsrp consumer portlets
	*/
	@Override
	public int getWSRPConsumerPortletsCount() {
		return _wsrpConsumerPortletLocalService.getWSRPConsumerPortletsCount();
	}

	@Override
	public int getWSRPConsumerPortletsCount(long wsrpConsumerId) {
		return _wsrpConsumerPortletLocalService.getWSRPConsumerPortletsCount(wsrpConsumerId);
	}

	@Override
	public void initFailedWSRPConsumerPortlets() {
		_wsrpConsumerPortletLocalService.initFailedWSRPConsumerPortlets();
	}

	@Override
	public void initWSRPConsumerPortlet(long companyId, long wsrpConsumerId,
		long wsrpConsumerPortletId, String wsrpConsumerPortletUuid,
		String name, String portletHandle)
		throws com.liferay.portal.kernel.exception.PortalException {
		_wsrpConsumerPortletLocalService.initWSRPConsumerPortlet(companyId,
			wsrpConsumerId, wsrpConsumerPortletId, wsrpConsumerPortletUuid,
			name, portletHandle);
	}

	@Override
	public void initWSRPConsumerPortlets() {
		_wsrpConsumerPortletLocalService.initWSRPConsumerPortlets();
	}

	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet updateWSRPConsumerPortlet(
		long wsrpConsumerPortletId, String name)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wsrpConsumerPortletLocalService.updateWSRPConsumerPortlet(wsrpConsumerPortletId,
			name);
	}

	/**
	* Updates the wsrp consumer portlet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wsrpConsumerPortlet the wsrp consumer portlet
	* @return the wsrp consumer portlet that was updated
	*/
	@Override
	public com.liferay.wsrp.model.WSRPConsumerPortlet updateWSRPConsumerPortlet(
		com.liferay.wsrp.model.WSRPConsumerPortlet wsrpConsumerPortlet) {
		return _wsrpConsumerPortletLocalService.updateWSRPConsumerPortlet(wsrpConsumerPortlet);
	}

	@Override
	public WSRPConsumerPortletLocalService getWrappedService() {
		return _wsrpConsumerPortletLocalService;
	}

	@Override
	public void setWrappedService(
		WSRPConsumerPortletLocalService wsrpConsumerPortletLocalService) {
		_wsrpConsumerPortletLocalService = wsrpConsumerPortletLocalService;
	}

	private WSRPConsumerPortletLocalService _wsrpConsumerPortletLocalService;
}