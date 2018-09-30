package tz.lion.smodel.logic.interpreter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tzxx
 * @date 2018/9/13
 */
public class LogicExpressionGroup {
    @Getter@Setter
    private List<Expression> expressions = new ArrayList<>();
    @Getter@Setter
    private Logic inLogic;
    @Getter@Setter
    private Logic outLogic;
    @Getter@Setter
    private int index;

    public LogicExpressionGroup() {
    }

    public LogicExpressionGroup(List<Expression> expressions, Logic inLogic, Logic outLogic, int index) {
        this.expressions = expressions;
        this.inLogic = inLogic;
        this.outLogic = outLogic;
        this.index = index;
    }


    public boolean merge(String str){
        int count = 0;
        AbstractLogicExpression expression1 = null;
        AbstractLogicExpression expression2 = null;
        try {
            for (Expression expression : expressions){
               if (count == 0){
                   expression1 = this.getInLogic().newInstance();
                   if(this.getInLogic().equals(Logic.AND)){
                       expression1.setExpression1(new TerminalExpression("", Compare.CONTAINS));
                   }else if(this.getInLogic().equals(Logic.OR)){
                       expression1.setExpression1(new TerminalExpression("", Compare.EQUALS));
                   }
                   expression1.setExpression2(expression);
                   count++;
               }else {
                   expression2 = this.getInLogic().newInstance();
                   expression2.setExpression1(expression1);
                   expression2.setExpression2(expression);
                   expression1 = expression2;
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(expression2 != null){
            return expression2.interpret(str);
        }
        return false;
    }
}
