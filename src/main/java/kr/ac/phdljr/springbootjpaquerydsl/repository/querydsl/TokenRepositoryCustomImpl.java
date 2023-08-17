package kr.ac.phdljr.springbootjpaquerydsl.repository.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ac.phdljr.springbootjpaquerydsl.domain.QTokens;
import kr.ac.phdljr.springbootjpaquerydsl.domain.Tokens;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TokenRepositoryCustomImpl implements TokenRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Tokens> findAllValidTokenByUsername(String userName) {
        QTokens t = QTokens.tokens;

        JPAQuery<Tuple> query = jpaQueryFactory
                .select(t.id, t.token, t.tokenType, t.expired, t.revoked, t.username)
                .from(t)
                .where(t.username.eq(userName));

        return query.fetch().stream().map(tuple -> Tokens.builder()
                            .id(tuple.get(t.id))
                            .token(tuple.get(t.token))
                            .tokenType(tuple.get(t.tokenType))
                            .expired(tuple.get(t.expired))
                            .revoked(tuple.get(t.revoked))
                            .username(tuple.get(t.username))
                        .build()
                ).toList();
    }
}
