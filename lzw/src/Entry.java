class Entry
{
    public static void main( String[] Args )
    {
        if (Args.length == 0) {
            Logger.get().registerFatalLog(Logger.MsgType.BAD_FILE, "No config mentioned");
            return;
        }
        Compressor compressor = new Compressor(Args[0]);
        System.out.println("Hello!");
        Logger.get().close();
    }
}