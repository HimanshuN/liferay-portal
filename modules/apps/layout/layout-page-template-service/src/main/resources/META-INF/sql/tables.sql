create table LayoutPageTemplateCollection (
	uuid_ VARCHAR(75) null,
	layoutPageTemplateCollectionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description STRING null,
	lastPublishDate DATE null
);

create table LayoutPageTemplateEntry (
	uuid_ VARCHAR(75) null,
	layoutPageTemplateEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	layoutPageTemplateCollectionId LONG,
	classNameId LONG,
	classTypeId LONG,
	name VARCHAR(75) null,
	type_ INTEGER,
	previewFileEntryId LONG,
	defaultTemplate BOOLEAN,
	layoutPrototypeId LONG,
	lastPublishDate DATE null,
	plid LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table LayoutPageTemplateStructure (
	uuid_ VARCHAR(75) null,
	layoutPageTemplateStructureId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	data_ STRING null
);