import java.util.List;
public class VNMEval implements VNMVisitor {
    public Object defaultVisit(SimpleNode node, Object data) throws Exception {
        int n = node.jjtGetNumChildren();
        for (int i = 0; i < n; i++) {
            node.jjtGetChild(i).jjtAccept(this, data);
        }
        return data;
    }
    // ---- default visitors ----
    public Object visit(SimpleNode n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTbody n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTclause n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTvar_decl n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTfn_decl n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTident_list n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTfn_call n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTexp_list n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTcondition_list n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTReturn n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTAssign n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTNULL n, Object d) throws Exception { return null; }
    public Object visit(ASTFor n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTWhile n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTidvec n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTidnum n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTidbool n, Object d) throws Exception { return defaultVisit(n,d); }
    public Object visit(ASTvec_const n, Object d) throws Exception { return defaultVisit(n,d); }
    // ---- print ----
// ---- print ----
public Object visit(ASTPrint node, Object data) throws Exception {
    for (int i = 0; i < node.jjtGetNumChildren(); i++) {
        Object v = node.jjtGetChild(i).jjtAccept(this, null);
        // handle boolean literals
        if (v instanceof Boolean) {
            System.out.print(((Boolean)v) ? "true" : "false");
        } else {
            System.out.print(v == null ? "" : v.toString());
        }
    }
    return null;
}
public Object visit(ASTPrint_ln node, Object data) throws Exception {
    for (int i = 0; i < node.jjtGetNumChildren(); i++) {
        Object v = node.jjtGetChild(i).jjtAccept(this, null);
        if (v instanceof Boolean) {
            System.out.print(((Boolean)v) ? "true" : "false");
        } else {
            System.out.print(v == null ? "" : v.toString());
        }
    }
    System.out.println();
    return null;
}
    // ---- if / else ----
    public Object visit(ASTIf node, Object data) throws Exception {
        int n = node.jjtGetNumChildren();
        int i = 0;
        while (i + 1 < n) {
            boolean cond = (Boolean) node.jjtGetChild(i).jjtAccept(this, null);
            if (cond) {
                node.jjtGetChild(i + 1).jjtAccept(this, null);
                return null;
            }
            i += 2;
        }
        if (i < n) node.jjtGetChild(i).jjtAccept(this, null);
        return null;
    }
    // ---- boolean logic ----
    public Object visit(ASTor node, Object data) throws Exception {
        boolean left = (Boolean) node.jjtGetChild(0).jjtAccept(this, null);
        if (left) return true;
        return (Boolean) node.jjtGetChild(1).jjtAccept(this, null);
    }
    public Object visit(ASTand node, Object data) throws Exception {
        boolean left = (Boolean) node.jjtGetChild(0).jjtAccept(this, null);
        if (!left) return false;
        return (Boolean) node.jjtGetChild(1).jjtAccept(this, null);
    }
    public Object visit(ASTnot node, Object data) throws Exception {
        boolean v = (Boolean) node.jjtGetChild(0).jjtAccept(this, null);
        return !v;
    }
    // ---- comparisons ----
    public Object visit(ASTcomparison node, Object data) throws Exception {
        Object a = node.jjtGetChild(0).jjtAccept(this, null);
        SimpleNode cmp = (SimpleNode) node.jjtGetChild(1);
        Object b = node.jjtGetChild(2).jjtAccept(this, null);
        if (cmp instanceof ASTle)  return (Integer)a < (Integer)b;
        if (cmp instanceof ASTleq) return (Integer)a <= (Integer)b;
        if (cmp instanceof ASTgre) return (Integer)a > (Integer)b;
        if (cmp instanceof ASTgeq) return (Integer)a >= (Integer)b;
        if (cmp instanceof ASTeq)  return a.equals(b);
        if (cmp instanceof ASTneq) return !a.equals(b);
        if (cmp instanceof ASTin) return vectorContains(b, a);
        if (cmp instanceof ASTnotin) return !vectorContains(b, a);
        return false;
    }
    // ---- helper for IN / NOT IN ----
    private boolean vectorContains(Object vecObj, Object elem) throws Exception {
        if (vecObj instanceof List) {
            List<?> vec = (List<?>) vecObj;
            for (Object v : vec) {
                if (v.equals(elem)) return true;
            }
        }
        return false;
    }
    // ---- arithmetic ----
    public Object visit(ASTsum node, Object data) throws Exception {
        int total = 0;
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            total += (Integer) node.jjtGetChild(i).jjtAccept(this, null);
        }
        return total;
    }
    public Object visit(ASTneg node, Object data) throws Exception {
        return - (Integer) node.jjtGetChild(0).jjtAccept(this, null);
    }
    public Object visit(ASTpos node, Object data) throws Exception {
        return node.jjtGetChild(0).jjtAccept(this, null);
    }
    public Object visit(ASTmul node, Object data) throws Exception {
        int a = (Integer) node.jjtGetChild(0).jjtAccept(this, null);
        int b = (Integer) node.jjtGetChild(1).jjtAccept(this, null);
        return a * b;
    }
    public Object visit(ASTdiv node, Object data) throws Exception {
        int a = (Integer) node.jjtGetChild(0).jjtAccept(this, null);
        int b = (Integer) node.jjtGetChild(1).jjtAccept(this, null);
        return a / b;
    }
    public Object visit(ASTmod node, Object data) throws Exception {
        int a = (Integer) node.jjtGetChild(0).jjtAccept(this, null);
        int b = (Integer) node.jjtGetChild(1).jjtAccept(this, null);
        return a % b;
    }
    // ---- constants ----
    public Object visit(ASTTRUE node, Object data) throws Exception { return Boolean.TRUE; }
    public Object visit(ASTFALSE node, Object data) throws Exception { return Boolean.FALSE; }
    // ---- literals ----
    public Object visit(ASTnumber node, Object data) throws Exception { 
        return Integer.parseInt(node.jjtGetValue().toString()); 
    }
    public Object visit(ASTstring node, Object data) throws Exception {
        Object v = node.jjtGetValue();
        if (v == null) return "";
        String s = v.toString();
        if (s.startsWith("\"") && s.endsWith("\"") && s.length() >= 2) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
    // ---- boolean function calls ----
public Object visit(ASTboolean_call node, Object data) throws Exception {
    return defaultVisit(node, data);
}
    public Object visit(ASTle node, Object data) throws Exception { return defaultVisit(node, data); }
    public Object visit(ASTleq node, Object data) throws Exception { return defaultVisit(node, data); }
    public Object visit(ASTgre node, Object data) throws Exception { return defaultVisit(node, data); }
    public Object visit(ASTgeq node, Object data) throws Exception { return defaultVisit(node, data); }
    public Object visit(ASTeq node, Object data) throws Exception { return defaultVisit(node, data); }
    public Object visit(ASTneq node, Object data) throws Exception { return defaultVisit(node, data); }
    public Object visit(ASTin node, Object data) throws Exception { return defaultVisit(node, data); }
    public Object visit(ASTnotin node, Object data) throws Exception { return defaultVisit(node, data); }
} // End class

