package springStudy.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 메모리에 db를 저장하는 것이기 때문에 TEST용이다.
@Component
public class MemoryMemberRepository implements MemberRepository
{
	private static Map<Long, Member> store = new HashMap<>();
	
	@Override
	public void save(Member member)
	{
		store.put(member.getId(), member);
	}
	
	@Override
	public Member findById(Long memberId)
	{
		return store.get(memberId);
	}
}
