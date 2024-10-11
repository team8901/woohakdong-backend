package woohakdong.server.api.controller.club;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import woohakdong.server.api.controller.club.dto.ClubAccountRegisterRequest;
import woohakdong.server.api.controller.club.dto.ClubAccountValidateRequest;
import woohakdong.server.api.controller.club.dto.ClubAccountValidateResponse;
import woohakdong.server.api.controller.club.dto.ClubCreateRequest;
import woohakdong.server.api.controller.club.dto.ClubCreateResponse;
import woohakdong.server.api.controller.club.dto.ClubInfoResponse;
import woohakdong.server.api.controller.club.dto.ClubJoinGatheringInfoResponse;

@RestController
@RequestMapping("/v1/clubs")
public class ClubController implements ClubControllerDocs {

    @PostMapping("/validate")
    public void validateClubName(String clubName) {

    }

    @PostMapping
    public ClubCreateResponse createClub(ClubCreateRequest clubCreateRequest) {
        return null;
    }

    @GetMapping("/{clubId}")
    public ClubInfoResponse getClubInfo(@PathVariable Long clubId) {
        return null;
    }

    @PutMapping("/{clubId}")
    public ClubInfoResponse updateClubInfo(@PathVariable Long clubId, ClubCreateRequest clubCreateRequest) {
        return null;
    }

    @PostMapping("/{clubId}/accounts")
    public ClubInfoResponse registerClubAccount(@PathVariable Long clubId, ClubAccountRegisterRequest clubAccountRegisterRequest) {
        return null;
    }

    @PostMapping("/accounts/validate")
    public ClubAccountValidateResponse validateClubAccount(ClubAccountValidateRequest clubAccountValidateRequest) {
        return null;
    }

    @GetMapping("/{clubId}/join")
    public ClubJoinGatheringInfoResponse getClubJoinInfo(@PathVariable Long clubId) {
        return null;
    }
}
