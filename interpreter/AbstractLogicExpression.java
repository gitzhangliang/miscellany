package tz.lion.smodel.logic.interpreter;

/**
 * @author tzxx
 * @date 2018/9/13
 */
public abstract class AbstractLogicExpression implements Expression {
    public abstract void setExpression1(Expression expression);
    public abstract void setExpression2(Expression expression);
}
