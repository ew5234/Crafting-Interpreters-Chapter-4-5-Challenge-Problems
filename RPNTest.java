package com.craftinginterpreters.lox;

public class RPNTest {
    public static void main(String[] args) {
        //Example: (1+2) * (4-3)

        Expr expression = 
        new Expr.Binary(
            new Expr.Grouping(
                new Expr.Binary(
                    new Expr.Literal(1), 
                    new Token(TokenType.PLUS, "+", null, 1),
                    new Expr.Literal(2)
                )
            ),
            new Token(TokenType.STAR, "*", null, 1),
            new Expr.Grouping(
                new Expr.Binary(
                    new Expr.Literal(4),
                    new Token(TokenType.MINUS, "-", null, 1),
                    new Expr.Literal(3)
                )
            )
        );

        RPNPrinter printer = new RPNPrinter();

        System.out.println(printer.print(expression));
                
    }
}
