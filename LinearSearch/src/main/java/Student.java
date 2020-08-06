public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Student another = (Student) obj;
        // 忽略大小写
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }
}
