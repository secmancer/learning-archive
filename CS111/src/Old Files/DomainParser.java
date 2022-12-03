public class DomainParser
{
    public static String getTopLevelDomain(String url)
    {
        String[] urlArray = url.split("[.]");
        return urlArray[urlArray.length - 1];
    }
}
