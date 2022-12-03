public class ArrayTools
{
    public static int printAll(String[] array)
    {
        int count = 0;
        for(int i = 0; i < array.length; i++)
        {
            System.out.println("[" + i + "]: " + array[i]);
            count++;
        }
        return count;
    }
    public static void copy(String[] original, String[] newArray)
    {
        if (newArray.length < original.length)
        {
            System.out.println("Error: Second array isn't big enough.");
        }
        else
        {
            for (int i = 0; i < newArray.length; i++)
            {
                newArray[i] = original[i];
            }
        }
    }
}
