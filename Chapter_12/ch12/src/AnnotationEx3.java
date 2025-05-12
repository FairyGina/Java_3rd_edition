import java.util.ArrayList;

class NewClass{
    int newField;

    int getNewField() {
        return newField;
    }

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() {
        return oldField;
    }
}

class AnnotationEx3 {
    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.oldField = 10;
        System.out.println(nc.getOldField());

        @SuppressWarnings ("unchecked")
        ArrayList<String> list = new ArrayList();
        list.add("nc");
    }
}