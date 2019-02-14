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

package com.liferay.shopping.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.shopping.model.ShoppingCart;
import com.liferay.shopping.model.ShoppingCartModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ShoppingCart service. Represents a row in the &quot;ShoppingCart&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ShoppingCartModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingCartImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCartImpl
 * @generated
 */
@ProviderType
public class ShoppingCartModelImpl extends BaseModelImpl<ShoppingCart>
	implements ShoppingCartModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shopping cart model instance should use the <code>ShoppingCart</code> interface instead.
	 */
	public static final String TABLE_NAME = "ShoppingCart";
	public static final Object[][] TABLE_COLUMNS = {
			{ "cartId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "itemIds", Types.CLOB },
			{ "couponCodes", Types.VARCHAR },
			{ "altShipping", Types.INTEGER },
			{ "insure", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("cartId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("itemIds", Types.CLOB);
		TABLE_COLUMNS_MAP.put("couponCodes", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("altShipping", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("insure", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table ShoppingCart (cartId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,itemIds TEXT null,couponCodes VARCHAR(75) null,altShipping INTEGER,insure BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table ShoppingCart";
	public static final String ORDER_BY_JPQL = " ORDER BY shoppingCart.cartId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ShoppingCart.cartId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.shopping.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.shopping.model.ShoppingCart"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.shopping.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.shopping.model.ShoppingCart"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.shopping.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.shopping.model.ShoppingCart"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long USERID_COLUMN_BITMASK = 2L;
	public static final long CARTID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.shopping.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.shopping.model.ShoppingCart"));

	public ShoppingCartModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cartId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCartId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cartId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ShoppingCart.class;
	}

	@Override
	public String getModelClassName() {
		return ShoppingCart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ShoppingCart, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ShoppingCart, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ShoppingCart, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((ShoppingCart)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ShoppingCart, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ShoppingCart, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((ShoppingCart)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<ShoppingCart, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ShoppingCart, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ShoppingCart, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<ShoppingCart, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<ShoppingCart, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<ShoppingCart, Object>>();
		Map<String, BiConsumer<ShoppingCart, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<ShoppingCart, ?>>();


		attributeGetterFunctions.put(
			"cartId",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getCartId();
				}

			});
		attributeSetterBiConsumers.put(
			"cartId",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object cartId) {
					shoppingCart.setCartId((Long)cartId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object groupId) {
					shoppingCart.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object companyId) {
					shoppingCart.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object userId) {
					shoppingCart.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object userName) {
					shoppingCart.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object createDate) {
					shoppingCart.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object modifiedDate) {
					shoppingCart.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"itemIds",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getItemIds();
				}

			});
		attributeSetterBiConsumers.put(
			"itemIds",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object itemIds) {
					shoppingCart.setItemIds((String)itemIds);
				}

			});
		attributeGetterFunctions.put(
			"couponCodes",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getCouponCodes();
				}

			});
		attributeSetterBiConsumers.put(
			"couponCodes",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object couponCodes) {
					shoppingCart.setCouponCodes((String)couponCodes);
				}

			});
		attributeGetterFunctions.put(
			"altShipping",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getAltShipping();
				}

			});
		attributeSetterBiConsumers.put(
			"altShipping",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object altShipping) {
					shoppingCart.setAltShipping((Integer)altShipping);
				}

			});
		attributeGetterFunctions.put(
			"insure",
			new Function<ShoppingCart, Object>() {

				@Override
				public Object apply(ShoppingCart shoppingCart) {
					return shoppingCart.getInsure();
				}

			});
		attributeSetterBiConsumers.put(
			"insure",
			new BiConsumer<ShoppingCart, Object>() {

				@Override
				public void accept(ShoppingCart shoppingCart, Object insure) {
					shoppingCart.setInsure((Boolean)insure);
				}

			});


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public long getCartId() {
		return _cartId;
	}

	@Override
	public void setCartId(long cartId) {
		_cartId = cartId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getItemIds() {
		if (_itemIds == null) {
			return "";
		}
		else {
			return _itemIds;
		}
	}

	@Override
	public void setItemIds(String itemIds) {
		_itemIds = itemIds;
	}

	@Override
	public String getCouponCodes() {
		if (_couponCodes == null) {
			return "";
		}
		else {
			return _couponCodes;
		}
	}

	@Override
	public void setCouponCodes(String couponCodes) {
		_couponCodes = couponCodes;
	}

	@Override
	public int getAltShipping() {
		return _altShipping;
	}

	@Override
	public void setAltShipping(int altShipping) {
		_altShipping = altShipping;
	}

	@Override
	public boolean getInsure() {
		return _insure;
	}

	@Override
	public boolean isInsure() {
		return _insure;
	}

	@Override
	public void setInsure(boolean insure) {
		_insure = insure;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ShoppingCart.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ShoppingCart toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ShoppingCart)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ShoppingCartImpl shoppingCartImpl = new ShoppingCartImpl();

		shoppingCartImpl.setCartId(getCartId());
		shoppingCartImpl.setGroupId(getGroupId());
		shoppingCartImpl.setCompanyId(getCompanyId());
		shoppingCartImpl.setUserId(getUserId());
		shoppingCartImpl.setUserName(getUserName());
		shoppingCartImpl.setCreateDate(getCreateDate());
		shoppingCartImpl.setModifiedDate(getModifiedDate());
		shoppingCartImpl.setItemIds(getItemIds());
		shoppingCartImpl.setCouponCodes(getCouponCodes());
		shoppingCartImpl.setAltShipping(getAltShipping());
		shoppingCartImpl.setInsure(isInsure());

		shoppingCartImpl.resetOriginalValues();

		return shoppingCartImpl;
	}

	@Override
	public int compareTo(ShoppingCart shoppingCart) {
		long primaryKey = shoppingCart.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingCart)) {
			return false;
		}

		ShoppingCart shoppingCart = (ShoppingCart)obj;

		long primaryKey = shoppingCart.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ShoppingCartModelImpl shoppingCartModelImpl = this;

		shoppingCartModelImpl._originalGroupId = shoppingCartModelImpl._groupId;

		shoppingCartModelImpl._setOriginalGroupId = false;

		shoppingCartModelImpl._originalUserId = shoppingCartModelImpl._userId;

		shoppingCartModelImpl._setOriginalUserId = false;

		shoppingCartModelImpl._setModifiedDate = false;

		shoppingCartModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ShoppingCart> toCacheModel() {
		ShoppingCartCacheModel shoppingCartCacheModel = new ShoppingCartCacheModel();

		shoppingCartCacheModel.cartId = getCartId();

		shoppingCartCacheModel.groupId = getGroupId();

		shoppingCartCacheModel.companyId = getCompanyId();

		shoppingCartCacheModel.userId = getUserId();

		shoppingCartCacheModel.userName = getUserName();

		String userName = shoppingCartCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			shoppingCartCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			shoppingCartCacheModel.createDate = createDate.getTime();
		}
		else {
			shoppingCartCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			shoppingCartCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			shoppingCartCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		shoppingCartCacheModel.itemIds = getItemIds();

		String itemIds = shoppingCartCacheModel.itemIds;

		if ((itemIds != null) && (itemIds.length() == 0)) {
			shoppingCartCacheModel.itemIds = null;
		}

		shoppingCartCacheModel.couponCodes = getCouponCodes();

		String couponCodes = shoppingCartCacheModel.couponCodes;

		if ((couponCodes != null) && (couponCodes.length() == 0)) {
			shoppingCartCacheModel.couponCodes = null;
		}

		shoppingCartCacheModel.altShipping = getAltShipping();

		shoppingCartCacheModel.insure = isInsure();

		return shoppingCartCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ShoppingCart, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<ShoppingCart, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ShoppingCart, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ShoppingCart)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ShoppingCart, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ShoppingCart, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ShoppingCart, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ShoppingCart)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ShoppingCart.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ShoppingCart.class, ModelWrapper.class
		};
	private long _cartId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _itemIds;
	private String _couponCodes;
	private int _altShipping;
	private boolean _insure;
	private long _columnBitmask;
	private ShoppingCart _escapedModel;
}