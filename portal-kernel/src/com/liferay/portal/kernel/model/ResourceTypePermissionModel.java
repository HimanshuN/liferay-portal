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

package com.liferay.portal.kernel.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the ResourceTypePermission service. Represents a row in the &quot;ResourceTypePermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.ResourceTypePermissionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.ResourceTypePermissionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypePermission
 * @generated
 */
@ProviderType
public interface ResourceTypePermissionModel extends BaseModel<ResourceTypePermission>,
	MVCCModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a resource type permission model instance should use the {@link ResourceTypePermission} interface instead.
	 */

	/**
	 * Returns the primary key of this resource type permission.
	 *
	 * @return the primary key of this resource type permission
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this resource type permission.
	 *
	 * @param primaryKey the primary key of this resource type permission
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this resource type permission.
	 *
	 * @return the mvcc version of this resource type permission
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this resource type permission.
	 *
	 * @param mvccVersion the mvcc version of this resource type permission
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the resource type permission ID of this resource type permission.
	 *
	 * @return the resource type permission ID of this resource type permission
	 */
	public long getResourceTypePermissionId();

	/**
	 * Sets the resource type permission ID of this resource type permission.
	 *
	 * @param resourceTypePermissionId the resource type permission ID of this resource type permission
	 */
	public void setResourceTypePermissionId(long resourceTypePermissionId);

	/**
	 * Returns the company ID of this resource type permission.
	 *
	 * @return the company ID of this resource type permission
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this resource type permission.
	 *
	 * @param companyId the company ID of this resource type permission
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this resource type permission.
	 *
	 * @return the group ID of this resource type permission
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this resource type permission.
	 *
	 * @param groupId the group ID of this resource type permission
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the name of this resource type permission.
	 *
	 * @return the name of this resource type permission
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this resource type permission.
	 *
	 * @param name the name of this resource type permission
	 */
	public void setName(String name);

	/**
	 * Returns the role ID of this resource type permission.
	 *
	 * @return the role ID of this resource type permission
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this resource type permission.
	 *
	 * @param roleId the role ID of this resource type permission
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the action IDs of this resource type permission.
	 *
	 * @return the action IDs of this resource type permission
	 */
	public long getActionIds();

	/**
	 * Sets the action IDs of this resource type permission.
	 *
	 * @param actionIds the action IDs of this resource type permission
	 */
	public void setActionIds(long actionIds);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ResourceTypePermission resourceTypePermission);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ResourceTypePermission> toCacheModel();

	@Override
	public ResourceTypePermission toEscapedModel();

	@Override
	public ResourceTypePermission toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}