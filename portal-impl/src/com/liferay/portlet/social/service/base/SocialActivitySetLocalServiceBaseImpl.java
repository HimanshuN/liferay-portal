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

package com.liferay.portlet.social.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.counter.kernel.service.persistence.CounterPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.liferay.social.kernel.model.SocialActivitySet;
import com.liferay.social.kernel.service.SocialActivitySetLocalService;
import com.liferay.social.kernel.service.persistence.SocialActivityFinder;
import com.liferay.social.kernel.service.persistence.SocialActivityPersistence;
import com.liferay.social.kernel.service.persistence.SocialActivitySetFinder;
import com.liferay.social.kernel.service.persistence.SocialActivitySetPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the social activity set local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.social.service.impl.SocialActivitySetLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.social.service.impl.SocialActivitySetLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class SocialActivitySetLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SocialActivitySetLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SocialActivitySetLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.social.kernel.service.SocialActivitySetLocalServiceUtil</code>.
	 */

	/**
	 * Adds the social activity set to the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialActivitySet the social activity set
	 * @return the social activity set that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SocialActivitySet addSocialActivitySet(
		SocialActivitySet socialActivitySet) {
		socialActivitySet.setNew(true);

		return socialActivitySetPersistence.update(socialActivitySet);
	}

	/**
	 * Creates a new social activity set with the primary key. Does not add the social activity set to the database.
	 *
	 * @param activitySetId the primary key for the new social activity set
	 * @return the new social activity set
	 */
	@Override
	@Transactional(enabled = false)
	public SocialActivitySet createSocialActivitySet(long activitySetId) {
		return socialActivitySetPersistence.create(activitySetId);
	}

	/**
	 * Deletes the social activity set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activitySetId the primary key of the social activity set
	 * @return the social activity set that was removed
	 * @throws PortalException if a social activity set with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SocialActivitySet deleteSocialActivitySet(long activitySetId)
		throws PortalException {
		return socialActivitySetPersistence.remove(activitySetId);
	}

	/**
	 * Deletes the social activity set from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialActivitySet the social activity set
	 * @return the social activity set that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SocialActivitySet deleteSocialActivitySet(
		SocialActivitySet socialActivitySet) {
		return socialActivitySetPersistence.remove(socialActivitySet);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SocialActivitySet.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return socialActivitySetPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.portlet.social.model.impl.SocialActivitySetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return socialActivitySetPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.portlet.social.model.impl.SocialActivitySetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return socialActivitySetPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return socialActivitySetPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return socialActivitySetPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SocialActivitySet fetchSocialActivitySet(long activitySetId) {
		return socialActivitySetPersistence.fetchByPrimaryKey(activitySetId);
	}

	/**
	 * Returns the social activity set with the primary key.
	 *
	 * @param activitySetId the primary key of the social activity set
	 * @return the social activity set
	 * @throws PortalException if a social activity set with the primary key could not be found
	 */
	@Override
	public SocialActivitySet getSocialActivitySet(long activitySetId)
		throws PortalException {
		return socialActivitySetPersistence.findByPrimaryKey(activitySetId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(socialActivitySetLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SocialActivitySet.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("activitySetId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(socialActivitySetLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(SocialActivitySet.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"activitySetId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(socialActivitySetLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SocialActivitySet.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("activitySetId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return socialActivitySetLocalService.deleteSocialActivitySet((SocialActivitySet)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return socialActivitySetPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the social activity sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.portlet.social.model.impl.SocialActivitySetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social activity sets
	 * @param end the upper bound of the range of social activity sets (not inclusive)
	 * @return the range of social activity sets
	 */
	@Override
	public List<SocialActivitySet> getSocialActivitySets(int start, int end) {
		return socialActivitySetPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of social activity sets.
	 *
	 * @return the number of social activity sets
	 */
	@Override
	public int getSocialActivitySetsCount() {
		return socialActivitySetPersistence.countAll();
	}

	/**
	 * Updates the social activity set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param socialActivitySet the social activity set
	 * @return the social activity set that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SocialActivitySet updateSocialActivitySet(
		SocialActivitySet socialActivitySet) {
		return socialActivitySetPersistence.update(socialActivitySet);
	}

	/**
	 * Returns the social activity set local service.
	 *
	 * @return the social activity set local service
	 */
	public SocialActivitySetLocalService getSocialActivitySetLocalService() {
		return socialActivitySetLocalService;
	}

	/**
	 * Sets the social activity set local service.
	 *
	 * @param socialActivitySetLocalService the social activity set local service
	 */
	public void setSocialActivitySetLocalService(
		SocialActivitySetLocalService socialActivitySetLocalService) {
		this.socialActivitySetLocalService = socialActivitySetLocalService;
	}

	/**
	 * Returns the social activity set persistence.
	 *
	 * @return the social activity set persistence
	 */
	public SocialActivitySetPersistence getSocialActivitySetPersistence() {
		return socialActivitySetPersistence;
	}

	/**
	 * Sets the social activity set persistence.
	 *
	 * @param socialActivitySetPersistence the social activity set persistence
	 */
	public void setSocialActivitySetPersistence(
		SocialActivitySetPersistence socialActivitySetPersistence) {
		this.socialActivitySetPersistence = socialActivitySetPersistence;
	}

	/**
	 * Returns the social activity set finder.
	 *
	 * @return the social activity set finder
	 */
	public SocialActivitySetFinder getSocialActivitySetFinder() {
		return socialActivitySetFinder;
	}

	/**
	 * Sets the social activity set finder.
	 *
	 * @param socialActivitySetFinder the social activity set finder
	 */
	public void setSocialActivitySetFinder(
		SocialActivitySetFinder socialActivitySetFinder) {
		this.socialActivitySetFinder = socialActivitySetFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the counter persistence.
	 *
	 * @return the counter persistence
	 */
	public CounterPersistence getCounterPersistence() {
		return counterPersistence;
	}

	/**
	 * Sets the counter persistence.
	 *
	 * @param counterPersistence the counter persistence
	 */
	public void setCounterPersistence(CounterPersistence counterPersistence) {
		this.counterPersistence = counterPersistence;
	}

	/**
	 * Returns the social activity local service.
	 *
	 * @return the social activity local service
	 */
	public com.liferay.social.kernel.service.SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	/**
	 * Sets the social activity local service.
	 *
	 * @param socialActivityLocalService the social activity local service
	 */
	public void setSocialActivityLocalService(
		com.liferay.social.kernel.service.SocialActivityLocalService socialActivityLocalService) {
		this.socialActivityLocalService = socialActivityLocalService;
	}

	/**
	 * Returns the social activity persistence.
	 *
	 * @return the social activity persistence
	 */
	public SocialActivityPersistence getSocialActivityPersistence() {
		return socialActivityPersistence;
	}

	/**
	 * Sets the social activity persistence.
	 *
	 * @param socialActivityPersistence the social activity persistence
	 */
	public void setSocialActivityPersistence(
		SocialActivityPersistence socialActivityPersistence) {
		this.socialActivityPersistence = socialActivityPersistence;
	}

	/**
	 * Returns the social activity finder.
	 *
	 * @return the social activity finder
	 */
	public SocialActivityFinder getSocialActivityFinder() {
		return socialActivityFinder;
	}

	/**
	 * Sets the social activity finder.
	 *
	 * @param socialActivityFinder the social activity finder
	 */
	public void setSocialActivityFinder(
		SocialActivityFinder socialActivityFinder) {
		this.socialActivityFinder = socialActivityFinder;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.social.kernel.model.SocialActivitySet",
			socialActivitySetLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.social.kernel.model.SocialActivitySet");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SocialActivitySetLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SocialActivitySet.class;
	}

	protected String getModelClassName() {
		return SocialActivitySet.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = socialActivitySetPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = SocialActivitySetLocalService.class)
	protected SocialActivitySetLocalService socialActivitySetLocalService;
	@BeanReference(type = SocialActivitySetPersistence.class)
	protected SocialActivitySetPersistence socialActivitySetPersistence;
	@BeanReference(type = SocialActivitySetFinder.class)
	protected SocialActivitySetFinder socialActivitySetFinder;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = CounterPersistence.class)
	protected CounterPersistence counterPersistence;
	@BeanReference(type = com.liferay.social.kernel.service.SocialActivityLocalService.class)
	protected com.liferay.social.kernel.service.SocialActivityLocalService socialActivityLocalService;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	@BeanReference(type = SocialActivityFinder.class)
	protected SocialActivityFinder socialActivityFinder;
	@BeanReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}