package springStudy.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService
{
	private final MemberRepository memberRepository;
	
	// 의존관계 주입을 자동으로 한다. AutoAppConfig에서 수동으로 하지 않고 자동으로 하려면 이렇게 해야한다.
	@Autowired // == ac.getBean(MemberRepository.class)
	public MemberServiceImpl(MemberRepository memberRepository)
	{
		this.memberRepository = memberRepository;
	}
	
	@Override
	public void join(Member member)
	{
		memberRepository.save(member);
	}
	
	@Override
	public Member findMember(Long memberId)
	{
		return memberRepository.findById(memberId);
	}
	
	// test
	public MemberRepository getMemberRepository()
	{
		return memberRepository;
	}
}
