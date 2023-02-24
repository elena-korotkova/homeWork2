import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop {
    private Scanner scan;
    private boolean Status=false;
    private Map<Integer,String> menu = new HashMap<Integer,String>();
    private Set<Notebook> devList = new HashSet<Notebook>();

    public void start_shop()
    {  
        this.welcome();
        this.Status = true;
        this.show_menu();
        this.fill_base();
        scan = new Scanner(System.in);
        String inp;
        inp = user_input();
        while(inp.compareToIgnoreCase("q")!=0)
        {   
            System.out.println();
            check_param(inp);
            System.out.println();
            inp = user_input();
        }

        scan.close();
        this.close_shop();
        System.out.println("By");

    }

    private void close_shop(){
        this.Status=false;
    }

    private void welcome()
        {   
            System.out.print("\033[H\033[J");
            System.out.println("Каталог ноутбуков v1.0");
            System.out.println();
    }
 
    private void fill_menu(){
        menu.put(1, "ОЗУ");
        menu.put(2, "Объем ЖД");
        menu.put(3, "Операционная система");
        menu.put(4, "Цвет");
        menu.put(5, "Цена");
        menu.put(6, "Сортировка");
        menu.put(7, "Показать все товары");
        
    }

    private void show_menu(){
        this.fill_menu();
        for(var item:menu.entrySet())
        {
            System.out.printf("%d - %s",item.getKey(),item.getValue());
            System.out.println();
        }
    }

    private String user_input()
    {
        System.out.print("выбор: ");
        return this.scan.nextLine();
    }

    public void add_note(String brand, Integer ram, Integer hddSize, String os, String color,double price)
    {
        if(this.Status){
            Notebook note = new Notebook();
            note.set_brand(brand);
            note.set_ram(ram);
            note.set_hddSize(hddSize);
            note.set_os(os);
            note.set_color(color);
            note.set_price(price);
            
            this.devList.add(note);
            
        }
    }

    private void fill_base()
    {
        this.add_note("Asus", 1024, 3000, "win11", "black",45000);
        this.add_note("Asus", 1024, 1000, "win11", "black",15000);
        this.add_note("Aser", 512, 10000, "winXP", "green",30000);
        this.add_note("HP", 2024, 120000, "win7", "black",20000);
        this.add_note("HP", 1024, 120000, "win7", "black",40000);
        this.add_note("MacBook", 16000, 250000, "MacOs", "gray",90000);
        this.add_note("Samsung", 8000, 9000, "DOS", "gray",70000);
        this.add_note("Zamsung", 8000, 9000, "DOS", "gray",70000);
        this.add_note("Zamsung", 8000, 9000, "DOS", "gray",30000);
        this.add_note("Zamsung", 8000, 9000, "DOS", "gray",60000);
        this.add_note("Huaway", 16000, 68000, "Win10", "gray",80000);
        this.add_note("Honor", 4000, 15000, "Win11", "white",80000);
        this.add_note("Honor", 4000, 15000, "Win11", "white",70000);
    }

    private void show_devList(){
        for(var item:devList)
        {
            System.out.printf("%s %d %d %s %s %f \n",item.get_brand(),item.get_ram(),item.get_hddSize(),item.get_os(),item.get_color(),item.get_price());
        }
    }

    private void check_param(String param)
    {
        switch(param)
        {
            case "1": this.show_ram();break;
            case "2": this.show_hddSize();break;
            case "3": this.show_os();break;
            case "4": this.show_color();break;
            case "5": this.show_price();break;
            case "6": this.sorted();break;
            case "7": this.show_devList();break;
        }
    }

    private void show_ram(){
        System.out.println(" Name     Ram ");
        for(var item:devList)
        {
            System.out.printf("%s     %d \n",item.get_brand(),item.get_ram());
        }
    }
    
    private void show_hddSize(){
        System.out.println(" Name     Hdd size ");
        
        for(var item:devList)
        {
            System.out.printf("%s     %d \n",item.get_brand(),item.get_hddSize());
        }
    }

    private void show_os(){
        System.out.println(" Name     OS ");      
        for(var item:devList)
        {
            System.out.printf("%s     %s \n",item.get_brand(),item.get_os());
        }
    }

    private void show_color(){
        System.out.println(" Name     Color ");     
        for(var item:devList)
        {
            System.out.printf("%s     %s \n",item.get_brand(),item.get_color());
        }
   
    }
    private void show_price(){
        System.out.println(" Name     Price ");     
        for(var item:devList)
        {
            System.out.printf("%s     %s \n",item.get_brand(),item.get_price());
        }
    }

    private void sorted()
    {
        System.out.println("Отсортированный массив");
        Set<Notebook> res = new LinkedHashSet<Notebook>();
        
        ArrayList<Notebook> tmp = new ArrayList<Notebook>(devList);
        
        while (tmp.size()>0)
        {
            Notebook min = tmp.get(0);
            int minInd = 0;

            for(int i=0;i<tmp.size();i++)
            {
                if (min.compareTo(tmp.get(i)) > 0)
                {
                    min = tmp.get(i);
                    minInd = i;
                }
                else if(min.compareTo(tmp.get(i))==0)
                {
                    if(min.get_price()<tmp.get(i).get_price())
                    {
                        min = tmp.get(i);
                        minInd = i;
                    }
                }
            }
            res.add(min);
            tmp.remove(minInd);
       
        } 

       
        this.show_devList(res);
        
        
    }

    private void show_devList(Set<Notebook> lst)
    {
        for(Notebook note:lst)
        {
            System.out.printf("%s %d %d %s %s %f \n",note.get_brand(),note.get_ram(),note.get_hddSize(),note.get_os(),note.get_color(),note.get_price());
        }
    }

}
