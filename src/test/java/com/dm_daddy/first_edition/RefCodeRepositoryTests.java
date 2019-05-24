//package com.dm_daddy.first_edition;
//
//import com.dm_daddy.first_edition.FirstEditionApplication;
//import com.dm_daddy.first_edition.Model.RefCode;
//import com.dm_daddy.first_edition.Model.SkillBonus;
//import com.dm_daddy.first_edition.Repositories.RefCodeRepository;
//import com.dm_daddy.first_edition.Repositories.SkillBonusRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
////@ContextConfiguration
//@SpringBootTest
//@DataJpaTest
//public class RefCodeRepositoryTests {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private RefCodeRepository refRepo;
//
//    @Autowired
//    SkillBonusRepository sbRepo;
//
//    @Test(expected = NullPointerException.class)
//    public void add_save_ref_code() {
//        RefCode r1 = new RefCode();
//        r1.setName("Pretend Parent #1");
//        r1 = entityManager.persistAndFlush(r1);
//        assertThat(refRepo.findById(r1.getId()).get()).isEqualTo(r1);
//
//    }
//
////    @Test(expected = NullPointerException.class)
////    public void find_all_ref_code() {
////        Iterable<RefCode> rc = refRepo.findAll();
////        assertThat(rc).isEmpty();
////    }
//
////    @Test
////    public void find_all_sb() {
////        Iterable<SkillBonus> sb = sbRepo.findAll();
////        assertThat(sb).isEmpty();
////    }
//
//}
