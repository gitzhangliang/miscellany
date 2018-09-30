package tz.lion.smodel.logic.interpreter;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tzxx
 * @date 2018/9/13
 */
public class AndLogicExpression extends AbstractLogicExpression {

    @Getter@Setter
    private Expression expression1 = null;
    @Getter@Setter
    private Expression expression2 = null;

    public AndLogicExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) && expression2.interpret(str);
    }

    public AndLogicExpression() {
    }
}

