package tz.lion.smodel.logic.interpreter;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tzxx
 * @date 2018/9/13
 */
public enum Logic {
    AND(AndLogicExpression.class),
    OR(OrLogicExpression.class);

    @Getter
    @Setter
    private Class<? extends AbstractLogicExpression> cls;

    Logic(Class<? extends AbstractLogicExpression> cls) {
        this.cls = cls;
    }

    Logic() {
        // TODO Auto-generated constructor stub
    }

    public AbstractLogicExpression newInstance() {
        try {
            return this.cls.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate class [" + cls.getName() + "]" + e);
        }
    }
}