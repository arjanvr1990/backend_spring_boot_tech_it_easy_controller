package com.novi.backend_spring_boot_tech_it_easy_controller.repositories;

import com.novi.backend_spring_boot_tech_it_easy_controller.models.Television;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TelevisionRepository extends JpaRepository<Television, Long> {
//    List<Television> findByType(String type);
//    List<Television> findByBrand(String brand);
//    List<Television> findByName(String name);
//    List<Television> findByPrice(Double price);
//    List<Television> findByPriceGreaterThanEqual(Double price);
//    List<Television> findByAvailableSize(Double availableSize);
//    List<Television> findByRefreshRate(Integer refreshRate);
//    List<Television> findByScreenType(String screenType);
//    List<Television> findByScreenQuality(String screenQuality);
//    List<Television> findBySmartTv(Boolean smartTv);
//    List<Television> findByWifi(Boolean wifi);
//    List<Television> findByVoiceControl(Boolean voiceControl);
//    List<Television> findByHdr(Boolean hdr);
//    List<Television> findByBluetooth(Boolean bluetooth);
//    List<Television> findByAmbiLight(Boolean ambiLight);
//    List<Television> findByOriginalStock(Integer originalStock);
//    List<Television> findBySold(Integer sold);


}
