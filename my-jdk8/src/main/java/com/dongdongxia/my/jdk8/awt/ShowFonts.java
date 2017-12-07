package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 
 * <P>Description: 显示电脑中的字体, 并且 鼠标点击的时候， 切换字体</P>
 * @ClassName: ShowFonts
 * @author java_liudong@163.com  2017年12月7日 下午3:23:43
 */
public class ShowFonts extends Applet implements MouseListener{

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    Font f;
    int next = 0;
    String[] fontList;
    String fontStr = "文泉驿微米黑";
    
    @Override
    public void init() {
        f = new Font("文泉驿微米黑", Font.PLAIN, 12);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setFont(f);
        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fontList = ge.getAvailableFontFamilyNames();
        
        int a1 = 1;
        
        for(int i = 0; i < fontList.length; i++) {
            if (i < 65) {
                g.drawString((i + 1) + ":" + fontList[i], 0, (a1++) * 15);
            } else if (i < 65 * 2 && i >= 65) {
                a1 = (i == 65) ? 1 : a1; 
                g.drawString((i + 1) + ":" + fontList[i], 200, (a1++) * 15);
            } else {
                a1 = (i == 65 * 2) ? 1 : a1;
                g.drawString((i + 1) + ":" + fontList[i], 450, (a1++) * 15);
            }
        }
        
        // 显示当前字体
        g.drawString(next + " : " + fontStr, 800, 500);
        g.drawString("还剩： " + (fontList.length - next), 800, 515);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        下面是四中
//        next++;
//        switch (next) {
//            case 0 :
//                f = new Font("Abyssinica SIL", Font.BOLD, 12);
//                break;
//            case 1 :
//                f = new Font("Andale Mono", Font.BOLD, 12);
//                break;
//            case 2 :
//                f = new Font("Courier 10 Pitch", Font.BOLD, 12);
//                break;
//            case 3 :
//                f = new Font("KacstDecorative", Font.BOLD, 12);
//                break;
//            case 4 :
//                f = new Font("Ubuntu", Font.BOLD, 12);
//                break;
//        }
//        if (next == 4) next = 0;
//        setFont(f);
//        repaint();
        fontStr = fontList[next++];
        if (next == fontList.length) next = 0;
        f = new Font(fontStr, Font.PLAIN, 12);
        setFont(f);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
/**
Abyssinica SIL
Andale Mono
Arial
Arial Black
AvantGarde LT Medium
Bitstream Charter
Bitstream Vera Sans
Bitstream Vera Sans Mono
Bitstream Vera Serif
Century Schoolbook L
Comic Sans MS
Courier 10 Pitch
Courier New
DejaVu Sans
DejaVu Sans Mono
DejaVu Serif
Dialog
DialogInput
Dingbats
Droid Sans Fallback
FreeMono
FreeSans
FreeSerif
Garuda
GE Inspira
Georgia
Impact
KacstArt
KacstBook
KacstDecorative
KacstDigital
KacstFarsi
KacstLetter
KacstNaskh
KacstOffice
KacstOne
KacstPen
KacstPoster
KacstQurn
KacstScreen
KacstTitle
KacstTitleL
Khmer OS
Khmer OS System
Kinnari
Laksaman
Lato
Lato Black
Lato Hairline
Lato Heavy
Lato Light
Lato Medium
Lato Semibold
Lato Thin
Liberation Mono
Liberation Sans
Liberation Sans Narrow
Liberation Serif
LKLUG
Lohit Punjabi
Loma
Lucida Bright
Lucida Sans
Lucida Sans Typewriter
Monospaced
mry_KacstQurn
NanumBarunGothic
NanumGothic
NanumMyeongjo
Nimbus Mono L
Nimbus Roman No9 L
Nimbus Sans L
Norasi
Noto Mono
Noto Sans CJK JP Black
Noto Sans CJK JP Bold
Noto Sans CJK JP DemiLight
Noto Sans CJK JP Light
Noto Sans CJK JP Medium
Noto Sans CJK JP Regular
Noto Sans CJK JP Thin
Noto Sans CJK KR Black
Noto Sans CJK KR Bold
Noto Sans CJK KR DemiLight
Noto Sans CJK KR Light
Noto Sans CJK KR Medium
Noto Sans CJK KR Regular
Noto Sans CJK KR Thin
Noto Sans CJK SC Black
Noto Sans CJK SC Bold
Noto Sans CJK SC DemiLight
Noto Sans CJK SC Light
Noto Sans CJK SC Medium
Noto Sans CJK SC Regular
Noto Sans CJK SC Thin
Noto Sans CJK TC Black
Noto Sans CJK TC Bold
Noto Sans CJK TC DemiLight
Noto Sans CJK TC Light
Noto Sans CJK TC Medium
Noto Sans CJK TC Regular
Noto Sans CJK TC Thin
Noto Sans Mono CJK JP Bold
Noto Sans Mono CJK JP Regular
Noto Sans Mono CJK KR Bold
Noto Sans Mono CJK KR Regular
Noto Sans Mono CJK SC Bold
Noto Sans Mono CJK SC Regular
Noto Sans Mono CJK TC Bold
Noto Sans Mono CJK TC Regular
OpenSymbol
Padauk
Padauk Book
Phetsarath OT
Purisa
Saab
SansSerif
Sawasdee
Serif
Standard Symbols L
STIX
STIX Math
STIXGeneral
STIXIntegralsD
STIXIntegralsSm
STIXIntegralsUp
STIXIntegralsUpD
STIXIntegralsUpSm
STIXNonUnicode
STIXSizeFiveSym
STIXSizeFourSym
STIXSizeOneSym
STIXSizeThreeSym
STIXSizeTwoSym
STIXVariants
Symbola
TakaoPGothic
Tibetan Machine Uni
Times New Roman
Tlwg Typist
Tlwg Typo
TlwgMono
TlwgTypewriter
Trebuchet MS
Ubuntu
Ubuntu Condensed
Ubuntu Light
Ubuntu Mono
Ume Gothic
Ume Gothic C4
Ume Gothic C5
Ume Gothic O5
Ume Gothic S4
Ume Gothic S5
Ume Mincho
Ume Mincho S3
Ume P Gothic
Ume P Gothic C4
Ume P Gothic C5
Ume P Gothic O5
Ume P Gothic S4
Ume P Gothic S5
Ume P Mincho
Ume P Mincho S3
Ume UI Gothic
Ume UI Gothic O5
Umpush
UnBatang
UnDinaru
UnDotum
UnGraphic
UnGungseo
UnPilgi
URW Bookman L
URW Chancery L
URW Gothic L
URW Palladio L
Verdana
Waree
Webdings
文泉驿微米黑
文泉驿等宽微米黑
 */
