package woohakdong.server.api.controller.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import woohakdong.server.api.controller.ListWrapperResponse;
import woohakdong.server.api.controller.item.dto.*;
import woohakdong.server.api.service.item.ItemService;


@RestController
@RequestMapping("/v1/clubs")
@RequiredArgsConstructor
public class ItemController implements ItemControllerDocs {

    private final ItemService itemService;

    @PostMapping("/{clubId}/items")
    public ItemRegisterResponse registerItem(@PathVariable Long clubId, @RequestBody ItemRegisterRequest request) {
        return itemService.registerItem(clubId, request);
    }

    @GetMapping("/{clubId}/items")
    public ListWrapperResponse<ItemResponse> getItems(@PathVariable Long clubId,
                                                      @RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false) String category,
                                                      @RequestParam(required = false) Boolean using,
                                                      @RequestParam(required = false) Boolean available,
                                                      @RequestParam(required = false) Boolean overdue) {
        return ListWrapperResponse.of(itemService.getItemsByFilters(clubId, keyword, category, using, available, overdue));
    }

    @GetMapping("/{clubId}/items/{itemId}")
    public ItemInfoResponse getItemInfo(@PathVariable Long clubId, @PathVariable Long itemId) {
        return itemService.getItemInfo(clubId, itemId);
    }

    @PostMapping("/{clubId}/items/{itemId}/borrow")
    public ItemBorrowResponse borrowItem(@PathVariable Long clubId, @PathVariable Long itemId) {
        return itemService.borrowItem(clubId, itemId);
    }

    @PostMapping("/{clubId}/items/{itemId}/return")
    public ItemReturnResponse returnItem(@PathVariable Long clubId, @PathVariable Long itemId,
                                         @RequestBody ItemReturnRequest request) {
        return itemService.returnItem(clubId, itemId, request);
    }

    @GetMapping("/{clubId}/items/{itemId}/history")
    public ListWrapperResponse<ItemHistoryResponse> getItemHistory(@PathVariable Long clubId,
                                                                   @PathVariable Long itemId) {
        return ListWrapperResponse.of(itemService.getItemHistory(clubId, itemId));
    }

    @PutMapping("/{clubId}/items/{itemId}")
    public ItemUpdateResponse updateItem(@PathVariable Long clubId, @PathVariable Long itemId,
                                         @RequestBody ItemUpdateRequest request) {
        return itemService.updateItem(clubId, itemId, request);
    }

    @DeleteMapping("/{clubId}/items/{itemId}")
    public void deleteItem(@PathVariable Long clubId, @PathVariable Long itemId) {
        itemService.deleteItem(clubId, itemId);
    }

    @PostMapping("/{clubId}/items/{itemId}/availability")
    public void updateItemAvailability(@PathVariable Long clubId,
                                       @PathVariable Long itemId,
                                       @RequestBody ItemAvailableUpdateRequest request) {
        itemService.updateItemAvailability(clubId, itemId, request);
    }

    @GetMapping("/{clubId}/items/borrowed")
    public ListWrapperResponse<ItemBorrowedResponse> getMyBorrowedItems(@PathVariable Long clubId) {
        return ListWrapperResponse.of(itemService.getMyBorrowedItems(clubId));
    }

    @GetMapping("/{clubId}/items/history")
    public ListWrapperResponse<ItemHistoryResponse> getMyHistoryItems(@PathVariable Long clubId) {
        return ListWrapperResponse.of(itemService.getMyHistoryItems(clubId));
    }

    @GetMapping("/{clubId}/items/history/{clubMemberId}")
    public ListWrapperResponse<ItemHistoryResponse> getClubMemberHistoryItems(@PathVariable Long clubId, @PathVariable Long clubMemberId) {
        return ListWrapperResponse.of(itemService.getClubMemberHistoryItems(clubId, clubMemberId));
    }
}
