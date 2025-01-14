package com.study.Board.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long saveMember(final MemberRequest params) {
        params.encodingPassword(passwordEncoder);
        memberMapper.save(params);
        return params.getId();
    }

    public MemberResponse findMemberByLongId(final String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    @Transactional
    public Long updateMember(final MemberRequest params) {
        params.encodingPassword(passwordEncoder);
        memberMapper.update(params);
        return params.getId();
    }

    @Transactional
    public Long deleteMemberById(final Long id) {
        memberMapper.deleteById(id);
        return id;
    }

    public int countMemberByLoginId(final String loginId) {
        return memberMapper.countByLoginId(loginId);
    }

    public MemberResponse login(final String loginId, final String password) {
        MemberResponse member = findMemberByLongId(loginId);
        String encodePassword=(member==null?"":member.getPassword());

        if (member==null||passwordEncoder.matches(password,encodePassword)){
            return null;
        }

        member.clearPassword();
        return member;
    }
}
