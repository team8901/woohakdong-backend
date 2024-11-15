package woohakdong.server.domain.ItemHistory;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woohakdong.server.common.exception.CustomErrorInfo;
import woohakdong.server.common.exception.CustomException;
import woohakdong.server.domain.club.Club;
import woohakdong.server.domain.item.Item;
import woohakdong.server.domain.member.Member;

@RequiredArgsConstructor
@Repository
public class ItemHistoryRepositoryImpl implements ItemHistoryRepository{

    private final ItemHistoryJpaRepository itemHistoryJpaRepository;

    @Override
    public ItemHistory save(ItemHistory itemHistory) {
        return itemHistoryJpaRepository.save(itemHistory);
    }

    @Override
    public ItemHistory getById(Long itemHistoryId) {
        return itemHistoryJpaRepository.findById(itemHistoryId)
                .orElseThrow(() -> new CustomException(CustomErrorInfo.ITEM_HISTORY_NOT_FOUND));
    }

    @Override
    public ItemHistory getActiveBorrowingRecord(Item item, Member member) {
        return itemHistoryJpaRepository.findByItemAndMemberAndItemReturnDateIsNull(item, member)
                .orElseThrow(() -> new CustomException(CustomErrorInfo.ITEM_HISTORY_NOT_FOUND));
    }

    @Override
    public List<ItemHistory> getAllByItem(Item item) {
        return itemHistoryJpaRepository.findByItemOrderByItemRentalDateDesc(item);
    }

    @Override
    public List<ItemHistory> getAllByMember(Member member) {
        return itemHistoryJpaRepository.findByMemberOrderByItemRentalDateDesc(member);
    }

    @Override
    public List<ItemHistory> getAllByClubAndMember(Club club, Member member) {
        return itemHistoryJpaRepository.findByItemClubAndMemberOrderByItemRentalDateDesc(club, member);
    }
}
