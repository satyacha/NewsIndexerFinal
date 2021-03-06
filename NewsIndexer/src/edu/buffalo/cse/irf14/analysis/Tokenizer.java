/**
 * 
 */
package edu.buffalo.cse.irf14.analysis;

/**
 * @author nikhillo Class that converts a given string into a
 *         {@link TokenStream} instance
 */
public class Tokenizer {
	/**
	 * Default constructor. Assumes tokens are whitespace delimited
	 */
	String delimiter;
	Token[] itemToken;

	public Tokenizer() {
		delimiter = "\\s";
	}

	/**
	 * Overloaded constructor. Creates the tokenizer with the given delimiter
	 * 
	 * @param delim
	 *            : The delimiter to be used
	 */
	public Tokenizer(String delim) {
		delimiter = delim;
	}

	/**
	 * Method to convert the given string into a TokenStream instance. This must
	 * only break it into tokens and initialize the stream. No other processing
	 * must be performed. Also the number of tokens would be determined by the
	 * string and the delimiter. So if the string were "hello world" with a
	 * whitespace delimited tokenizer, you would get two tokens in the stream.
	 * But for the same text used with lets say "~" as a delimiter would return
	 * just one token in the stream.
	 * 
	 * @param str
	 *            : The string to be consumed
	 * @return : The converted TokenStream as defined above
	 * @throws TokenizerException
	 *             : In case any exception occurs during tokenization
	 */
	public TokenStream consume(String str) throws TokenizerException {
		try {
			String[] tokenList = str.split(delimiter);
			int listLength = tokenList.length;
			itemToken = new Token[listLength];
			TokenStream termStream = null;
			int flag = 0;
			if (str != null && str.length() > 0) {
				for (int i = 0; i < listLength; i++) {
					itemToken[i] = new Token();
					itemToken[i].setTermText(tokenList[i]);
				}
				termStream = new TokenStream(itemToken);
				return termStream;
			} else
				throw new TokenizerException("Null string passed");
		} catch (Exception e) {
			if (!(e instanceof TokenizerException))
				throw new TokenizerException("Exception in Tokeniser class");
			else
				throw new TokenizerException("Null string passed");
		}
	}
}
