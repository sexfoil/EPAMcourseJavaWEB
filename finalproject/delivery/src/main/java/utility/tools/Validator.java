package utility.tools;

import model.entity.CargoType;
import model.entity.Street;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Validator {

    public static boolean isValid(String str) {
        return true;
    }

    public static boolean isAddressNumber(String number) {
        return !number.equals("");
    }

    public static boolean isPhoneNumber(String number) {
        return !number.equals("");
    }

    public static CargoType isCargoTypeValid(List<CargoType> cargoTypes, int weight) {

        Optional<CargoType> matchingType = cargoTypes.stream()
                .filter(cargo -> weight > cargo.getMinWeight() && weight <= cargo.getMaxWeight()).findFirst();

        return matchingType.orElse(null);
    }

    public static Street isStreetValid(List<Street> streets, String name) {

        Optional<Street> matchingStreet = streets.stream().filter(n -> name.equals(n.getName())).findFirst();

        return matchingStreet.orElse(null);

    }

    public static LocalDateTime isDateValid(String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);
        return dateTime.isAfter(LocalDateTime.now()) ? dateTime : null;
    }

}
