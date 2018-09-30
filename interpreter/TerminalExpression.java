package tz.lion.smodel.logic.interpreter;

/**
 * @author tzxx
 * @date 2018/9/13
 */
public class TerminalExpression implements Expression {
    private String literal;
    private Compare compare;

    public TerminalExpression(String str, Compare compare) {
        this.literal = str;
        this.compare = compare;
    }
    @Override
    public boolean interpret(String str) {
        if(Compare.CONTAINS.equals(this.compare)){
            if (str.contains(literal)) {
                return true;
            }
        }else if(Compare.EQUALS.equals(this.compare)){
            if (str.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
