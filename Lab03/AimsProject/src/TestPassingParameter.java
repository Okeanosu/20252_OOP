public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", "Adventure", "Director", 120, 10.01f);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", "Animation", "Director", 90, 6.67f);
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
    }
    // Incorrect Swap Method and changeTitle Method:
/*     public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void swapTitle(Object 01, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }*/
    // Correct Swap Method:
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tempTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tempTitle);
    }
}




