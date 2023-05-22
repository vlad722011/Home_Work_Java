package Home_Work_6;

import java.util.Objects;

public class Notebook {
    String brand;
    String volumeRam;
    String volumeHardDisk;
    String operationSystem;
    String color;

    public Notebook(String brand, String volumeRam, String volumeHardDisk, String operationSystem, String color) {
        this.brand = brand;
        this.volumeRam = volumeRam;
        this.volumeHardDisk = volumeHardDisk;
        this.operationSystem = operationSystem;
        this.color= color;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(brand).append(" ").append(volumeRam).append(" ").append(volumeHardDisk)
                .append(" ").append(operationSystem).append(" ").append(color);
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, volumeRam, volumeHardDisk, operationSystem, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Notebook)) {
            return false;
        }
        Notebook notebook = new Notebook(brand,volumeRam,volumeHardDisk,operationSystem,color);
        return (notebook.brand.equals(this.brand) && notebook.volumeRam.equals(this.volumeRam)
                && notebook.volumeHardDisk.equals(this.volumeHardDisk) && notebook.operationSystem.equals(this.operationSystem)
                && notebook.color.equals(this.color));
    }

}
