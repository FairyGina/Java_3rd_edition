class WrapperEx3{
    public static void main(String[] args) {
        int i=10;

        Integer intg=(Integer)i; 
        Object obj=(Object)i;

        Long lng=100L;

        int i2=intg+10;
        long l=intg+lng;

        Integer intg2=new Integer(20);
        int i3=(int)intg2;

        Integer intg3=intg2+i3;

        System.out.println("i   ="+i);
        System.out.println("intg="+intg);
        System.out.println("obj ="+obj);
        System.out.println("lng ="+lng);
        System.out.println("intg + 10   ="+i2);
        System.out.println("intg + lng   ="+l);
        System.out.println("intg2 ="+intg2);
        System.out.println("i3 ="+i3);
        System.out.println("intg2 + i3 ="+intg3);


    }
}