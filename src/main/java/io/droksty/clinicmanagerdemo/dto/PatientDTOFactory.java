package io.droksty.clinicmanagerdemo.dto;

public class PatientDTOFactory {

    private PatientDTOFactory() {}

    public static PatientDTO createFromUserInput(String citizenId, String lastname, String firstname, String email, String phoneNumber) {
        PatientDTO dto = new PatientDTO();
        dto.setCitizenId(citizenId);
        dto.setLastname(lastname);
        dto.setFirstname(firstname);
        dto.setEmail(email);
        dto.setPhoneNumber(phoneNumber);
        return dto;
    }
}
