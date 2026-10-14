package shiyan3;
public class shiyanneiron2 {
public static void main(String[] args) {
Soldier commander = new Soldier();
commander.name ="Desmond";
Soldier advisor = new Soldier();
advisor.name = "Henry";
Soldier[] group1, group2;
group1 = new Soldier[5];
group1[0] = commander;
group1[1] = advisor;
for(int i=2;i<5;i++)
{
group1[i] = new Soldier();
}
group1[2].name = "Clark";
group1[3].name = "Aaron";
group1[4].name = "Tommy";
System.out.println("In group1");
for(Soldier current:group1)
{
System.out.println(current.name + " " +current.life);
}
group2=new Soldier[3];
group2[0] = advisor;
group2[1] = group1[3];
group2[2] = new Soldier();
System.out.println("In group2");
for(Soldier current:group2)
{
System.out.println(current.name + " " +current.life);
}
group2[1].life = 80;
advisor.name = "Ken";
System.out.println("After change group2[1] and advisor, in group1");
for(Soldier current:group1)
{
System.out.println(current.name + " " +current.life);
}
}
}
class Soldier
{
public String name = "noname";
public int life = 100;
}