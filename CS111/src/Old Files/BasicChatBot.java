public class BasicChatBot
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Nothing to say?");
        }
        else
        {
            boolean favoritePresent = false;

            boolean arePresent = false;
            int areIndex = 0;

            boolean youPresent = false;
            int youIndex = 0;

            for (int i = 0; i < args.length; i++)
            {
                String currWord = args[i].toLowerCase();
                if (currWord.equals("are") || currWord.equals("are93"))
                {
                    arePresent = true;
                    areIndex = i;
                }
                else if (currWord.equals("you") || currWord.equals("yyou") || currWord.equals("you?"))
                {
                    youPresent = true;
                    youIndex = i;
                } else if (currWord.equals("favorite") || currWord.equals("favorite3"))
                {
                    favoritePresent = true;
                }
            }
            if (areIndex < youIndex && arePresent && youPresent)
            {
                System.out.println("Fine, but could use some more power.");
            } else if (favoritePresent) {
                String item = args[args.length - 1];
                System.out.println(item + " I'm only interested in transistors.");
            } else {
                System.out.println("I didn't understand that.");
            }
        }
    }
}
