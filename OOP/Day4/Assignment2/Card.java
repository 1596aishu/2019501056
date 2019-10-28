class Menu {
    public static void main(String[] args) {
        Card HP = new Card("Chamber of Secrets","J K Rowling","Fiction");
        Card HP1 = new Card("Chamber of Secrets1","J K Rowling","Fiction");
        Card Science = new Card("Transmission","Thareja","Electrical");
        Card Social = new Card("Constitution","Valmiki","Civics");
        CardCatalog cc = new CardCatalog();
        cc.addACard(HP);
        cc.addACard(HP1);
        cc.addACard(Science);
        cc.addACard(Social);
        cc.printCatalog();
        System.out.println();
        Card [] printGetSubject = cc.getSubject("Fiction");
        int lengthSubject = printGetSubject.length;
        for (int i=0; i<lengthSubject; i++) {
            if (printGetSubject[i] != null){
                System.out.println(printGetSubject[i].title);}
        }
        System.out.println();
        Card [] printGetAuthor = cc.getAAuthor("J K Rowling");
        int lengthAuthor = printGetAuthor.length;
        for (int i=0; i<lengthAuthor; i++) {
            if (printGetAuthor[i] != null){
                System.out.println(printGetAuthor[i].title);
            }
        }
        System.out.println();
        System.out.println((cc.getATitle("Constitution")).author);
        System.out.println();
        cc.removeATitle("Transmission");
        cc.printCatalog();
    }
}


class Card {
    String title;
    String author;
    String subject;
    Card(String title, String author, String subject) {
        this.title = title;
        this.author = author;
        this.subject = subject;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getSubject() {
        return this.subject;
    }
    public String toString() {
        return author+", "+title+", "+subject;
    }
}

class CardCatalog {
    int count = 0;
    Card [] cardArray; 
    CardCatalog(){
        cardArray = new Card[10];
    }

    public void addACard(Card c) {
        this.cardArray[this.count] = c;
        this.count += 1;
    } 

    public Card getATitle(String title) {
        for(int i=0; i<this.count; i++) {
            if(this.cardArray[i].title.equals(title)){
                return this.cardArray[i];
            }
        }
        return null;
    }

    public Card [] getAAuthor(String author) {
        int c = 0;
        Card [] array = new Card[count];
        for(int i=0; i<this.count; i++) {
            if(this.cardArray[i].author.equals(author)){
                array[c] = this.cardArray[i];
                c += 1;
            }
        }
        return array;
    }

    public Card [] getSubject(String subject) {
        int c = 0;
        Card [] a = new Card[count];
        for(int i=0; i<this.count; i++) {
            if(this.cardArray[i].subject.equals(subject)){
                a[c] = this.cardArray[i];
                c += 1;
            }
        }
        return a;
    } 

    public void removeATitle(String title) {
        for(int i=0; i<count; i++) {
            if(this.cardArray[i].title.equals(title)){
                this.cardArray[i] = null;
            }
        }
    }

    public void printCatalog() {
        for (int i=0; i< count; i++) {
            if (this.cardArray[i] != null) {
                System.out.println(cardArray[i]);
            }
        }
    }
}