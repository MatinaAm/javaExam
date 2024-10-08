package utils.functions;

import utils.enums.NaturalResource;

public class ParseResources {
    public static NaturalResource[] parseResources(String resourceInput) {
        if (resourceInput == null || resourceInput.trim().isEmpty()) {
            return new NaturalResource[]{NaturalResource.NONE}; // Return NONE if input is empty
        }

        String[] resourceNames = resourceInput.split(",\\s*"); // Split by commas and optional spaces
        NaturalResource[] resources = new NaturalResource[resourceNames.length];

        try {
            for (int i = 0; i < resourceNames.length; i++) {
                resources[i] = NaturalResource.valueOf(resourceNames[i].toUpperCase()); // Convert to enum
            }
        } catch (IllegalArgumentException e) {
            System.out.println("یک یا چند منبع نامعتبر وارد شده است. از NONE استفاده می‌شود.");
            return new NaturalResource[]{NaturalResource.NONE}; // Return NONE if any resource is invalid
        }

        return resources; // Return valid resources
    }
}