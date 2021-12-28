package day04;

public class FileReaderMain {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("src/main/resources/datamunging/");
        String fileNameWeather = "weather.dat";
        String fileNameFootball = "football.dat";

        System.out.println(fileReader.findSmallestTemperatureSpread(fileNameWeather));
        System.out.println(fileReader.findSmallestDifference(fileNameFootball));
    }
}