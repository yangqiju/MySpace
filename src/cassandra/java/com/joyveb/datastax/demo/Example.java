package com.joyveb.datastax.demo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import me.prettyprint.hector.api.query.RangeSlicesQuery;

import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.QueryBuilder;
/**
 * 条件表达式
 * K表的主键类型
 * V表对应column的值的类型
 */
public class Example<K> {

	private List<Expression<?>> expressions = new ArrayList<Expression<?>>();
	private List<Clause> clauses = new ArrayList<Clause>();
	/**
	 * 增加>=表达式
	 * @param <V>
	 * @param columnName
	 * @param value
	 * @return
	 */
	public <V> Example<K> addGteExpress(String columnName, V value){
		expressions.add(this.new GteExpression<V>(columnName, value));
		return this;
	}
	
	/**
	 * 增加>表达式
	 * @param <V>
	 * @param columnName
	 * @param value
	 * @return
	 */
	public <V> Example<K> addGtExpress(String columnName, V value){
		expressions.add(this.new GtExpression<V>(columnName, value));
		return this;
	}
	
	/**
	 * 增加=表达式
	 * @param <V>
	 * @param columnName
	 * @param value
	 * @return
	 */
	public <V> Example<K> addEqExpress(String columnName, V value){
		expressions.add(this.new EqualsExpression<V>(columnName, value));
		return this;
	}
	
	/**
	 * 增加<=表达式
	 * @param <V>
	 * @param columnName
	 * @param value
	 * @return
	 */
	public <V> Example<K> addLteExpress(String columnName, V value){
		expressions.add(this.new LteExpression<V>(columnName, value));
		return this;
	}
	
	/**
	 * 增加<表达式
	 * @param <V>
	 * @param columnName
	 * @param value
	 * @return
	 */
	public <V> Example<K> addLtExpress(String columnName, V value){
		expressions.add(this.new LtExpression<V>(columnName, value));
		return this;
	}
	
	public List<Clause> appendExp2Query() {
		for(Expression<?> expression : expressions){
			clauses.add(expression.getExpressionClause());
		}
		return clauses;
	}
	
	/**
	 * 条件表达式
	 */
	public abstract class Expression<V>{
		
		private String fieldName;
		
		private V value;
		
		protected Expression(String fieldName, V value) {
			super();
			this.fieldName = fieldName;
			this.value = value;
		}

		private Clause getExpressionClause() {
			return getClause(fieldName, value);
		}
		
		protected abstract Clause getClause(String columnName, Object value);
	}
	
	/**
	 *	>=
	 * @param <V>
	 */
	public class GteExpression<V> extends Expression<V>{

		public GteExpression(String fieldName, V value) {
			super(fieldName, value);
		}

		@Override
		protected Clause getClause(String columnName, Object value) {
			return QueryBuilder.gte(columnName, value);
		}

	}
	
	/**
	 *	<=
	 * @param <V>
	 */
	public class LteExpression<V> extends Expression<V>{
		public LteExpression(String fieldName, V value) {
			super(fieldName, value);
		}

		@Override
		protected Clause getClause(String columnName, Object value) {
			return QueryBuilder.lte(columnName, value);
		}

	}
	
	/**
	 *	>
	 * @param <V>
	 */
	public class GtExpression<V> extends Expression<V>{

		public GtExpression(String fieldName, V value) {
			super(fieldName, value);
		}

		@Override
		protected Clause getClause(String columnName, Object value) {
			return QueryBuilder.gt(columnName, value);
		}
	}
	
	/**
	 *	<
	 * @param <V>
	 */
	public class LtExpression<V> extends Expression<V>{

		public LtExpression(String fieldName, V value) {
			super(fieldName, value);
		}

		@Override
		protected Clause getClause(String columnName, Object value) {
			return QueryBuilder.lt(columnName, value);
		}

	}
	
	/**
	 *	=
	 * @param <V>
	 */
	public class EqualsExpression<V> extends Expression<V>{

		public EqualsExpression(String fieldName, V value) {
			super(fieldName, value);
		}

		@Override
		protected Clause getClause(String columnName, Object value) {
			return QueryBuilder.eq(columnName, value);
		}

	}
}
