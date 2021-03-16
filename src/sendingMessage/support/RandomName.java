package sendingMessage.support;

public class RandomName {
    public static String randomName() {
        String string = new String ("йцукенгшщзхъфывапролджэячсмитьбю");
        String randomName = new String();
        int lengthString = string.length();
        int lengthNewName = 4;
        for (int i=0;i<lengthNewName;i++){
            int randElem = (int)(lengthString*Math.random());
            randomName = randomName+string.substring(randElem, randElem+1);
        }
        return randomName;

    }
}
