package woohakdong.server.api.controller.item.dto;

import lombok.Builder;
import woohakdong.server.domain.ItemHistory.ItemHistory;
import woohakdong.server.domain.item.Item;
import woohakdong.server.domain.member.Member;

import java.time.LocalDateTime;

@Builder
public record ItemHistoryResponse(
        Long itemHistoryId,
        Long clubMemberId,
        String memberName,
        LocalDateTime itemRentalDate,
        LocalDateTime itemDueDate,
        LocalDateTime itemReturnDate,
        String itemReturnImage,
        String itemName,
        Boolean itemOverdue,
        Long itemId
) {
    public static ItemHistoryResponse from(ItemHistory itemHistory, Long clubMemberId, Item item, Boolean itemOverdue) {
        return ItemHistoryResponse.builder()
                .itemHistoryId(itemHistory.getItemHistoryId())
                .clubMemberId(clubMemberId)
                .memberName(itemHistory.getMemberName())
                .itemRentalDate(itemHistory.getItemRentalDate())
                .itemDueDate(itemHistory.getItemDueDate())
                .itemReturnDate(itemHistory.getItemReturnDate())
                .itemReturnImage(itemHistory.getItemReturnImage())
                .itemName(item.getItemName())
                .itemOverdue(itemOverdue)
                .itemId(item.getItemId())
                .build();
    }
}
