package parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class TestLexer {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("source.txt");
        GrammarLexer textLexer = new GrammarLexer(input);
        Token token;
        while ((token = textLexer.nextToken()).getType() != GrammarLexer.EOF) {
            System.out.printf("Line: %d \tcolumn: %d \tlexeme: '%s' \ttype: %d, \t  " +
                    "token: %s\n", token.getLine(), token.getCharPositionInLine() + 1, token.getText(),
            token.getType(), textLexer.getVocabulary().getDisplayName(token.getType()));
        }
        System.out.println("Traza lexer finalizada");
    }
}
