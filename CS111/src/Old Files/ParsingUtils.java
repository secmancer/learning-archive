public class ParsingUtils
{
    public static void changeLetter(StringBuilder sb, char letter)
    {
        String text = sb.toString();
        for (int i = 0; i < text.length(); i++)
        {
            char currentChar = text.charAt(i);
            if (currentChar == letter)
            {
                sb.setCharAt(i, Character.toUpperCase(letter));
            }
        }
    }

    public static void changeLetter(StringBuilder sb, String letters)
    {
        for (int i = 0; i < letters.length(); i++)
        {
            char currChar = letters.charAt(i);
            changeLetter(sb, currChar);
        }
    }
}
