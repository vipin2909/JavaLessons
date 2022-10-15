public class Lesson1 {
    public static void main(String[] args) {
        byte bigbyte = (byte)127;
        short bigShort = 32767;
        int bigInt = 210000000;
        long bigLong = 922000000000000000L;
        float bigFloat = 3.14F;
        double bigDouble = 3.148237948722347923748;

        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        boolean trueOrFalse = true;
        char randomChar = 66;
        char anotherChar = 'A';
        char escapedChar = '\0';
        char escapedBr = '\b';
        char escapedtab = '\t';

        String byteString = Byte.toString(bigbyte);
        int stringToInt = Integer.parseInt(byteString);
//        parseShort parseLong parseByte parseFloat parseDouble parseBoolean

        System.out.println(escapedBr);
    }
}
