/*     */ package mainstuff;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Item
/*     */ {
/*     */   private int itemType;
/*     */   private int addatk;
/*     */   private int addHealth;
/*     */   private int addSpd;
/*     */   private int addLuck;
/*     */   private int addIntel;
/*     */   private int baseDmg;
/*     */   private int endDmg;
/*     */   private int actionNum;
/*     */   private String discription;
/*     */ 
/*     */   public String getDiscription()
/*     */   {
/*  21 */     return this.discription;
/*     */   }
/*     */ 
/*     */   public int getItemType()
/*     */   {
/*  28 */     return this.itemType;
/*     */   }
/*     */ 
/*     */   public void setItemType(int itemType)
/*     */   {
/*  34 */     this.itemType = itemType;
/*     */   }
/*     */ 
/*     */   public int getAddatk()
/*     */   {
/*  40 */     return this.addatk;
/*     */   }
/*     */ 
/*     */   public void setAddatk(int addatk)
/*     */   {
/*  46 */     this.addatk = addatk;
/*     */   }
/*     */ 
/*     */   public int getAddHealth()
/*     */   {
/*  52 */     return this.addHealth;
/*     */   }
/*     */ 
/*     */   public void setAddHealth(int addHealth)
/*     */   {
/*  58 */     this.addHealth = addHealth;
/*     */   }
/*     */ 
/*     */   public int getAddSpd()
/*     */   {
/*  64 */     return this.addSpd;
/*     */   }
/*     */ 
/*     */   public void setAddSpd(int addSpd)
/*     */   {
/*  70 */     this.addSpd = addSpd;
/*     */   }
/*     */ 
/*     */   public int getAddIntel()
/*     */   {
/*  76 */     return this.addIntel;
/*     */   }
/*     */ 
/*     */   public void setAddIntel(int addIntel)
/*     */   {
/*  82 */     this.addIntel = addIntel;
/*     */   }
/*     */ 
/*     */   public int getBaseDmg()
/*     */   {
/*  88 */     return this.baseDmg;
/*     */   }
/*     */ 
/*     */   public void setBaseDmg(int baseDmg)
/*     */   {
/*  94 */     this.baseDmg = baseDmg;
/*     */   }
/*     */ 
/*     */   public int getEndDmg()
/*     */   {
/* 100 */     return this.endDmg;
/*     */   }
/*     */ 
/*     */   public void setEndDmg(int endDmg)
/*     */   {
/* 106 */     this.endDmg = endDmg;
/*     */   }
/*     */ 
/*     */   public int getActionNum()
/*     */   {
/* 112 */     return this.actionNum;
/*     */   }
/*     */ 
/*     */   public void setActionNum(int actionNum)
/*     */   {
/* 118 */     this.actionNum = actionNum;
/*     */   }
/*     */ 
/*     */   public int getAddLuck()
/*     */   {
/* 124 */     return this.addLuck;
/*     */   }
/*     */ 
/*     */   public void setAddLuck(int addLuck)
/*     */   {
/* 130 */     this.addLuck = addLuck;
/*     */   }
/*     */   public Item() {
/* 133 */     this.itemType = 0;
/* 134 */     this.addatk = 0;
/* 135 */     this.addHealth = 0;
/* 136 */     this.addSpd = 0;
/* 137 */     this.addLuck = 0;
/* 138 */     this.addIntel = 0;
/* 139 */     this.baseDmg = 0;
/* 140 */     this.endDmg = 0;
/* 141 */     this.actionNum = 0;
/* 142 */     this.discription = "";
/*     */   }
/*     */ 
/*     */   public Item(int iT, int aA, int aH, int aS, int aL, int aI, int bD, int eD, int aN, String string) {
/* 146 */     this.itemType = iT;
/* 147 */     this.addatk = aA;
/* 148 */     this.addHealth = aH;
/* 149 */     this.addSpd = aS;
/* 150 */     this.addLuck = aL;
/* 151 */     this.addIntel = aI;
/* 152 */     this.baseDmg = bD;
/* 153 */     this.endDmg = eD;
/* 154 */     this.actionNum = aN;
/* 155 */     this.discription = string;
/*     */   }
/*     */ 
/*     */   public Item(int lvl) {
/* 159 */     Random generator = new Random();
/* 160 */     int roll = generator.nextInt(lvl);
/* 161 */     this.addatk = roll;
/* 162 */     roll = generator.nextInt(lvl);
/* 163 */     this.addHealth = roll;
/* 164 */     roll = generator.nextInt(lvl);
/* 165 */     this.addIntel = roll;
/* 166 */     roll = generator.nextInt(lvl);
/* 167 */     this.addLuck = roll;
/* 168 */     roll = generator.nextInt(lvl);
/* 169 */     this.addSpd = roll;
/* 170 */     roll = generator.nextInt(lvl);
/* 171 */     this.baseDmg = roll;
/* 172 */     roll = generator.nextInt(lvl + 5) + lvl;
/* 173 */     this.endDmg = roll;
/* 174 */     roll = generator.nextInt(2);
/* 175 */     this.itemType = roll;
/* 176 */     roll = generator.nextInt(1);
/* 177 */     this.actionNum = roll;
/*     */   }
/*     */ }

/* Location:           C:\eclipse\WEB-INF\classes\
 * Qualified Name:     myproject.Item
 * JD-Core Version:    0.6.2
 */