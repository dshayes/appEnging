/*     */ package mainstuff;
/*     */ 
/*     */ public class Fighter
/*     */ {
/*     */   private int charater_ID;
/*     */   private String name;
/*     */   private int xp;
/*     */   private int akt_power;
/*     */   private int health;
/*     */   private int intel;
/*     */   private int luck;
/*     */   private int speed;
/*     */   private Item fighterItem;
/*     */   private Item fighterItemTwo;
/*     */   private Tactics tactics;
/*     */ 
/*     */   public int getCharater_ID()
/*     */   {
/*  23 */     return this.charater_ID;
/*     */   }
/*     */ 
/*     */   public void setCharater_ID(int charater_ID)
/*     */   {
/*  30 */     this.charater_ID = charater_ID;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  37 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  44 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Fighter(int charaterID, String name, int xp, int akt_power, int health, int speed, int luck, int intel, Item itemOne, Item itemTwo) {
/*  48 */     this.charater_ID = charaterID;
/*  49 */     this.name = name;
/*  50 */     this.xp = xp;
/*  51 */     this.akt_power = (akt_power + itemOne.getAddatk() + itemTwo.getAddatk());
/*  52 */     this.health = (health + itemOne.getAddHealth() + itemTwo.getAddHealth());
/*  53 */     this.speed = (speed + itemOne.getAddSpd() + itemTwo.getAddSpd());
/*  54 */     this.luck = (luck + itemOne.getAddLuck() + itemTwo.getAddLuck());
/*  55 */     this.intel = (intel + itemOne.getAddIntel() + itemTwo.getAddIntel());
/*  56 */     this.fighterItem = itemOne;
/*  57 */     this.fighterItemTwo = itemTwo;
/*  58 */     this.tactics = new Tactics(this.health);
/*     */   }
/*     */ 
/*     */   public int getXp()
/*     */   {
/*  65 */     return this.xp;
/*     */   }
/*     */ 
/*     */   public void setXp(int xp)
/*     */   {
/*  72 */     this.xp = xp;
/*     */   }
/*     */ 
/*     */   public int getAkt_poiwer() {
/*  76 */     return this.akt_power;
/*     */   }
/*     */ 
/*     */   public void setAkt_poiwer(int akt_power) {
/*  80 */     this.akt_power = akt_power;
/*     */   }
/*     */ 
/*     */   public int getHealth() {
/*  84 */     return this.health;
/*     */   }
/*     */ 
/*     */   public void setHealth(int health) {
/*  88 */     this.health = health;
/*     */   }
/*     */ 
/*     */   public int getIntel() {
/*  92 */     return this.intel;
/*     */   }
/*     */ 
/*     */   public void setIntel(int intel) {
/*  96 */     this.intel = intel;
/*     */   }
/*     */   public int getLuck() {
/*  99 */     return this.luck;
/*     */   }
/*     */   public void setLuck(int luck) {
/* 102 */     this.luck = luck;
/*     */   }
/*     */ 
/*     */   public int getSpeed() {
/* 106 */     return this.speed;
/*     */   }
/*     */ 
/*     */   public void setSpeed(int speed) {
/* 110 */     this.speed = speed;
/*     */   }
/*     */ 
/*     */   public Item getFighterItem()
/*     */   {
/* 117 */     return this.fighterItem;
/*     */   }
/*     */ 
/*     */   public void setFighterItem(Item fighterItem)
/*     */   {
/* 124 */     this.fighterItem = fighterItem;
/*     */   }
/*     */ 
/*     */   public Item getFighterItemTwo()
/*     */   {
/* 131 */     return this.fighterItemTwo;
/*     */   }
/*     */ 
/*     */   public void setFighterItemTwo(Item fighterItemTwo)
/*     */   {
/* 138 */     this.fighterItemTwo = fighterItemTwo;
/*     */   }
/*     */ 
/*     */   public Tactics getTactics() {
/* 142 */     return this.tactics;
/*     */   }
/*     */ 
/*     */   public void setTactics(Tactics tactics) {
/* 146 */     this.tactics = tactics;
/*     */   }
/*     */ 
/*     */   public int performAction()
/*     */   {
/* 152 */     return this.tactics.getNextAction(this.health);
/*     */   }
/*     */ }

/* Location:           C:\eclipse\WEB-INF\classes\
 * Qualified Name:     myproject.Fighter
 * JD-Core Version:    0.6.2
 */