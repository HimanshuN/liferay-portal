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

import java.util.Date;

/**
 * The base model interface for the LayoutSetBranch service. Represents a row in the &quot;LayoutSetBranch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.LayoutSetBranchModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.LayoutSetBranchImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetBranch
 * @generated
 */
@ProviderType
public interface LayoutSetBranchModel extends BaseModel<LayoutSetBranch>,
	GroupedModel, MVCCModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a layout set branch model instance should use the {@link LayoutSetBranch} interface instead.
	 */

	/**
	 * Returns the primary key of this layout set branch.
	 *
	 * @return the primary key of this layout set branch
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this layout set branch.
	 *
	 * @param primaryKey the primary key of this layout set branch
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this layout set branch.
	 *
	 * @return the mvcc version of this layout set branch
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this layout set branch.
	 *
	 * @param mvccVersion the mvcc version of this layout set branch
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the layout set branch ID of this layout set branch.
	 *
	 * @return the layout set branch ID of this layout set branch
	 */
	public long getLayoutSetBranchId();

	/**
	 * Sets the layout set branch ID of this layout set branch.
	 *
	 * @param layoutSetBranchId the layout set branch ID of this layout set branch
	 */
	public void setLayoutSetBranchId(long layoutSetBranchId);

	/**
	 * Returns the group ID of this layout set branch.
	 *
	 * @return the group ID of this layout set branch
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this layout set branch.
	 *
	 * @param groupId the group ID of this layout set branch
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this layout set branch.
	 *
	 * @return the company ID of this layout set branch
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this layout set branch.
	 *
	 * @param companyId the company ID of this layout set branch
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this layout set branch.
	 *
	 * @return the user ID of this layout set branch
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this layout set branch.
	 *
	 * @param userId the user ID of this layout set branch
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this layout set branch.
	 *
	 * @return the user uuid of this layout set branch
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this layout set branch.
	 *
	 * @param userUuid the user uuid of this layout set branch
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this layout set branch.
	 *
	 * @return the user name of this layout set branch
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this layout set branch.
	 *
	 * @param userName the user name of this layout set branch
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this layout set branch.
	 *
	 * @return the create date of this layout set branch
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this layout set branch.
	 *
	 * @param createDate the create date of this layout set branch
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this layout set branch.
	 *
	 * @return the modified date of this layout set branch
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this layout set branch.
	 *
	 * @param modifiedDate the modified date of this layout set branch
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the private layout of this layout set branch.
	 *
	 * @return the private layout of this layout set branch
	 */
	public boolean getPrivateLayout();

	/**
	 * Returns <code>true</code> if this layout set branch is private layout.
	 *
	 * @return <code>true</code> if this layout set branch is private layout; <code>false</code> otherwise
	 */
	public boolean isPrivateLayout();

	/**
	 * Sets whether this layout set branch is private layout.
	 *
	 * @param privateLayout the private layout of this layout set branch
	 */
	public void setPrivateLayout(boolean privateLayout);

	/**
	 * Returns the name of this layout set branch.
	 *
	 * @return the name of this layout set branch
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this layout set branch.
	 *
	 * @param name the name of this layout set branch
	 */
	public void setName(String name);

	/**
	 * Returns the description of this layout set branch.
	 *
	 * @return the description of this layout set branch
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this layout set branch.
	 *
	 * @param description the description of this layout set branch
	 */
	public void setDescription(String description);

	/**
	 * Returns the master of this layout set branch.
	 *
	 * @return the master of this layout set branch
	 */
	public boolean getMaster();

	/**
	 * Returns <code>true</code> if this layout set branch is master.
	 *
	 * @return <code>true</code> if this layout set branch is master; <code>false</code> otherwise
	 */
	public boolean isMaster();

	/**
	 * Sets whether this layout set branch is master.
	 *
	 * @param master the master of this layout set branch
	 */
	public void setMaster(boolean master);

	/**
	 * Returns the logo ID of this layout set branch.
	 *
	 * @return the logo ID of this layout set branch
	 */
	public long getLogoId();

	/**
	 * Sets the logo ID of this layout set branch.
	 *
	 * @param logoId the logo ID of this layout set branch
	 */
	public void setLogoId(long logoId);

	/**
	 * Returns the theme ID of this layout set branch.
	 *
	 * @return the theme ID of this layout set branch
	 */
	@AutoEscape
	public String getThemeId();

	/**
	 * Sets the theme ID of this layout set branch.
	 *
	 * @param themeId the theme ID of this layout set branch
	 */
	public void setThemeId(String themeId);

	/**
	 * Returns the color scheme ID of this layout set branch.
	 *
	 * @return the color scheme ID of this layout set branch
	 */
	@AutoEscape
	public String getColorSchemeId();

	/**
	 * Sets the color scheme ID of this layout set branch.
	 *
	 * @param colorSchemeId the color scheme ID of this layout set branch
	 */
	public void setColorSchemeId(String colorSchemeId);

	/**
	 * Returns the css of this layout set branch.
	 *
	 * @return the css of this layout set branch
	 */
	@AutoEscape
	public String getCss();

	/**
	 * Sets the css of this layout set branch.
	 *
	 * @param css the css of this layout set branch
	 */
	public void setCss(String css);

	/**
	 * Returns the settings of this layout set branch.
	 *
	 * @return the settings of this layout set branch
	 */
	@AutoEscape
	public String getSettings();

	/**
	 * Sets the settings of this layout set branch.
	 *
	 * @param settings the settings of this layout set branch
	 */
	public void setSettings(String settings);

	/**
	 * Returns the layout set prototype uuid of this layout set branch.
	 *
	 * @return the layout set prototype uuid of this layout set branch
	 */
	@AutoEscape
	public String getLayoutSetPrototypeUuid();

	/**
	 * Sets the layout set prototype uuid of this layout set branch.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid of this layout set branch
	 */
	public void setLayoutSetPrototypeUuid(String layoutSetPrototypeUuid);

	/**
	 * Returns the layout set prototype link enabled of this layout set branch.
	 *
	 * @return the layout set prototype link enabled of this layout set branch
	 */
	public boolean getLayoutSetPrototypeLinkEnabled();

	/**
	 * Returns <code>true</code> if this layout set branch is layout set prototype link enabled.
	 *
	 * @return <code>true</code> if this layout set branch is layout set prototype link enabled; <code>false</code> otherwise
	 */
	public boolean isLayoutSetPrototypeLinkEnabled();

	/**
	 * Sets whether this layout set branch is layout set prototype link enabled.
	 *
	 * @param layoutSetPrototypeLinkEnabled the layout set prototype link enabled of this layout set branch
	 */
	public void setLayoutSetPrototypeLinkEnabled(
		boolean layoutSetPrototypeLinkEnabled);

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
	public int compareTo(LayoutSetBranch layoutSetBranch);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LayoutSetBranch> toCacheModel();

	@Override
	public LayoutSetBranch toEscapedModel();

	@Override
	public LayoutSetBranch toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}