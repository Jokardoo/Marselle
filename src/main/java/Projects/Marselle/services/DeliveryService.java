package Projects.Marselle.services;

import Projects.Marselle.models.furniture.Delivery;
import Projects.Marselle.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public DeliveryRepository getDeliveryRepository() {
        return deliveryRepository;
    }

    public Optional<Delivery> findByDate(Date date) {
        return deliveryRepository.findByDate(date);
    }

}
