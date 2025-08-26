import java.util.ArrayList;


public class batalhanaval2 {
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private void comecarjogo() {
        Startup one = new Startup();
        one.setName("poniez");
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        three.setName("cabista");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("Seu objetivo é afundar três startups ");
        System.out.println("poniez  hacqi  cabista");
        System.out.println("tente afundar todas com o menor numero de tentativas");

        for (Startup startup : startups) {
            ArrayList<String> newLocation = helper.placeStartup(3);
        }
    }

    
}
