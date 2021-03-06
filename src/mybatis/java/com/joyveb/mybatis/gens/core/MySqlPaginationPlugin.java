package com.joyveb.mybatis.gens.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：OracelPaginationPlugin   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-5 下午4:21:38   
 * 修改备注：   
 * @version    
 *    
 */
public class MySqlPaginationPlugin extends PluginAdapter{

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		Field field = new Field();
		field.setName("offset");
		field.setType(FullyQualifiedJavaType.getIntInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		field.addJavaDocLine("/**");
		field.addJavaDocLine("* This method was generated by MyBatis Generator.");
		field.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		field.addJavaDocLine("*");
		DateFormat df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
		field.addJavaDocLine("* @generated "+df.format(new Date()));
		field.addJavaDocLine("*/");
		topLevelClass.addField(field);
		
		field = new Field();
		field.setName("limit");
		field.setType(FullyQualifiedJavaType.getIntInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		field.addJavaDocLine("/**");
		field.addJavaDocLine("* This method was generated by MyBatis Generator.");
		field.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		field.addJavaDocLine("*");
		df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
		field.addJavaDocLine("* @generated "+df.format(new Date()));
		field.addJavaDocLine("*/");
		topLevelClass.addField(field);
		
		Method method = new Method();
		method.setName("setOffset");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "offset"));
		method.setReturnType(null);
		method.addBodyLine(" this.offset = offset;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*");
		df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
		method.addJavaDocLine("* @generated "+df.format(new Date()));
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		method = new Method();
		method.setName("getOffset");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.addBodyLine("  return offset;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*");
		df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
		method.addJavaDocLine("* @generated "+df.format(new Date()));
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		method = new Method();
		method.setName("setLimit");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "limit"));
		method.setReturnType(null);
		method.addBodyLine(" this.limit = limit;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*");
		df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
		method.addJavaDocLine("* @generated "+df.format(new Date()));
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		method = new Method();
		method.setName("getLimit");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.addBodyLine("  return limit;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*");
		df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
		method.addJavaDocLine("* @generated "+df.format(new Date()));
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		field = new Field();
		field.setName("sumCol");
		field.setType(FullyQualifiedJavaType.getStringInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		field.addJavaDocLine("/**");
		field.addJavaDocLine("* This method was generated by MyBatis Generator.");
		field.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		field.addJavaDocLine("*/");
		topLevelClass.addField(field);
		
		method = new Method();
		method.setName("setSumCol");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "sumCol"));
		method.setReturnType(null);
		method.addBodyLine(" this.sumCol = sumCol;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		method = new Method();
		method.setName("getSumCol");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.addBodyLine("  return sumCol;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		field = new Field();
		field.setName("groupSelClause");
		field.setType(FullyQualifiedJavaType.getStringInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		field.addJavaDocLine("/**");
		field.addJavaDocLine("* This method was generated by MyBatis Generator.");
		field.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		field.addJavaDocLine("*/");
		topLevelClass.addField(field);
		
		method = new Method();
		method.setName("setGroupSelClause");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "groupSelClause"));
		method.setReturnType(null);
		method.addBodyLine(" this.groupSelClause = groupSelClause;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		method = new Method();
		method.setName("getGroupSelClause");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.addBodyLine("  return groupSelClause;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		field = new Field();
		field.setName("groupByClause");
		field.setType(FullyQualifiedJavaType.getStringInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		field.addJavaDocLine("/**");
		field.addJavaDocLine("* This method was generated by MyBatis Generator.");
		field.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		field.addJavaDocLine("*/");
		topLevelClass.addField(field);
		
		method = new Method();
		method.setName("setGroupByClause");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "groupByClause"));
		method.setReturnType(null);
		method.addBodyLine(" this.groupByClause = groupByClause;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		method = new Method();
		method.setName("getGroupByClause");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.addBodyLine("  return groupByClause;");
		method.addJavaDocLine("/**");
		method.addJavaDocLine("* This method was generated by MyBatis Generator.");
		method.addJavaDocLine("* This method corresponds to the database table "+introspectedTable.getFullyQualifiedTableNameAtRuntime());
		method.addJavaDocLine("*/");
		topLevelClass.addMethod(method);
		
		List<Method> methods = topLevelClass.getMethods();
		for(Method mod : methods){
			if(mod.getName().equals("clear")){
				mod.addBodyLine("this.offset= 0;");
				mod.addBodyLine("this.limit= Integer.MAX_VALUE;");
				mod.addBodyLine("this.sumCol=null;");
				mod.addBodyLine("this.groupSelClause=null;");
				mod.addBodyLine("this.groupByClause=null;");
			}
			String examplename = introspectedTable.getExampleType().substring(introspectedTable.getExampleType().lastIndexOf(".")+1);
			if(mod.getName().equals(examplename)){
				mod.addBodyLine("offset = 0;");
				mod.addBodyLine("limit = Integer.MAX_VALUE;");
			}
		}
		return true;
	}
	
	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {
		XmlElement rootelement = document.getRootElement();
		String pkname = "";
		String resultmap = "";
		String tablename = "";
		String whereclause = "";
		tablename = introspectedTable.getTableConfiguration().getTableName().toUpperCase();
		List<IntrospectedColumn> pklist = introspectedTable.getPrimaryKeyColumns();
		for(IntrospectedColumn pkcol:pklist){
			pkname = pkcol.getActualColumnName();
			break;
		}
		if(pkname.length()<=0){
			pklist = introspectedTable.getNonBLOBColumns();
			for(IntrospectedColumn pkcol:pklist){
				pkname = pkcol.getActualColumnName();
				break;
			}
		}
		
		String xmlstr = document.getFormattedContent();
		Pattern patt = Pattern.compile("<resultMap\\s*id=\"(.*)\"");
		Matcher m = patt.matcher(xmlstr);
		if(m.matches()){
			resultmap = m.group(1);
		}else{
			resultmap = "BaseResultMap";
		}
		patt = Pattern.compile("<sql\\s*id=\"(.*)\"");
		m = patt.matcher(xmlstr);
		if(m.matches()){
			whereclause = m.group(1);
			if(whereclause.indexOf(".")==-1){
//				whereclause = tablename+"."+whereclause;
			}
		}else{
//			whereclause = tablename+".Example_Where_Clause";
			whereclause = "Example_Where_Clause";
		}
		DateFormat df =  new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
		
		String pagetailtemplate = "<sql id=\"mysql_Pagination_Tail\" >\r\n" +
								  "	<if test=\"offset !=null and limit !=null\">\r\n" +
								  "		limit #{offset} ,#{limit} \r\n" +
								  "		 </if> \r\n" +
								  "  </sql>\r\n";
		
		TextElement pagetail = new TextElement(pagetailtemplate);
		rootelement.addElement(3, pagetail);
		
		//*****************************************************
		String template = "<select id=\"sumByExample\" resultType=\"java.lang.Integer\" parameterType=\""+introspectedTable.getExampleType()+"\"  >\r\n" +
				  "	<!--\r\n" +
				  "	WARNING - @generated\r\n" +
				  "	This element is automatically generated by MyBatis Generator, do not modify.\r\n" +
				  "	This element was generated on "+df.format(new Date())+".\r\n" +
				  "	-->\r\n" +
				  "	select \r\n" +
				  "		<if test=\"sumCol != null\" >\r\n" +
				  "			(case when sum(#{sumCol}) is null then 0 else sum(#{sumCol}) end)\r\n" +
				  "		</if>\r\n" +
				  "		<if test=\"sumCol == null\" >\r\n" +
				  "			(case when sum(1) is null then 0 else sum(1) end)\r\n" +
				  "		</if>\r\n" +
				  "			from FINDTABLE \r\n" +
				  "		<include refid=\"FINDWHERE\" />\r\n" +
				  "</select>\r\n";
		template = template.replaceAll("FINDTABLE", tablename).replaceAll("FINDWHERE", whereclause);
		Element sumByExample = new TextElement(template);
		rootelement.addElement(sumByExample);
		
		template = "<select id=\"groupByExample\" resultType=\"java.util.HashMap\" parameterType=\""+introspectedTable.getExampleType()+"\"  >\r\n" +
				  "	<!--\r\n" +
				  "	WARNING - @generated\r\n" +
				  "	This element is automatically generated by MyBatis Generator, do not modify.\r\n" +
				  "	This element was generated on "+df.format(new Date())+".\r\n" +
				  "	-->\r\n" +
				  "	select \r\n" +
				  " 	<if test=\"groupSelClause!=null\" >\r\n"+
				  " 		#{groupSelClause}	\r\n"+
				  " 	</if>	\r\n"+
				  " 	from FINDTABLE	\r\n"+
				  " 	<include refid=\"Example_Where_Clause\" />\r\n"+
				  " 	<if test=\"groupByClause!=null\" >\r\n"+
				  " 		group by #{groupByClause} \r\n"+
				  " 	</if>	\r\n"+
				  "		<if test=\"orderByClause!=null\" > \r\n"+
				  " 		order by #{orderByClause}	\r\n"+
				  " 	</if>	\r\n"+
				  "</select>\r\n";
		template = template.replaceAll("FINDTABLE", tablename).replaceAll("FINDWHERE", whereclause);
		Element groupByExample = new TextElement(template);
		rootelement.addElement(groupByExample);
		return true;
	}
	
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		XmlElement pagetail = new XmlElement("include");
		pagetail.addAttribute(new Attribute("refid", "mysql_Pagination_Tail"));
		element.addElement(pagetail);
		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,
				introspectedTable);
	}
	
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

}
