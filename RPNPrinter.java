package com.craftinginterpreters.lox;

class RPNPrinter implements Expr.Visitor<String>{

    String print(Expr expr){
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        String left = expr.left.accept(this);
        String right = expr.right.accept(this);

        return left + " " + right + " " + expr.operator.lexeme;
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping grouping) {
        return grouping.expression.accept(this);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal literal){
        if (literal.value == null){
            return "nil";
        }
        return literal.value.toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary unary) {
        String right = unary.right.accept(this); {
            return right + " " + unary.operator.lexeme;
        }
    }

    @Override
    public String visitAssignExpr(Expr.Assign expr) {
        return expr.value.accept(this);
    }
    
    @Override
    public String visitCallExpr(Expr.Call expr){
        return "call";
    }

    @Override
    public String visitGetExpr(Expr.Get expr){
        return "get";
    }

    @Override
    public String visitLogicalExpr(Expr.Logical expr) {
        String left = expr.left.accept(this);
        String right = expr.right.accept(this);

        return left + " " + right + " " + expr.operator.lexeme;
    }

    @Override
    public String visitSetExpr(Expr.Set expr) {
        return expr.value.accept(this);
    }

    @Override
    public String visitSuperExpr(Expr.Super expr) {
        return "super";
    }

    @Override
    public String visitThisExpr(Expr.This expr){
        return "this";
    }

    public String visitVariableExpr(Expr.Variable expr){
        return expr.name.lexeme;
    }

}
