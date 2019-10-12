class Entry
{
    public static void main( String[] Args )
    {
        if (Args.length == 0)
            Logger.get().registerLog(Logger.ErrorType.BAD_FILE, "No config mentioned");
        Compressor compressor = new Compressor(Args[0]);
        System.out.println("Hello!");
    }
}